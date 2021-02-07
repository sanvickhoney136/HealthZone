package com.example.medimok.views.fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.print.PageRange;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.medimok.R;
import com.example.medimok.databinding.FragmentHomeBinding;
import com.example.medimok.preference.PreferenceManager;
import com.example.medimok.repository.BodyStatusRepo;
import com.example.medimok.utils.CommonUtils;
import com.github.angads25.toggle.interfaces.OnToggledListener;
import com.github.angads25.toggle.model.ToggleableView;
import com.github.angads25.toggle.widget.LabeledSwitch;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private LabeledSwitch labeledSwitch;
    private CommonUtils commonUtils;
    private FusedLocationProviderClient fusedLocation;
    private String TAG = HomeFragment.class.getName();
    private LocationRequest mLocationRequest;
    private long UPDATE_INTERVAL = 40 * 1000;  /* 30 secs */
    private long FASTEST_INTERVAL = 40000; /* 30 sec */
    private LocationCallback mLocationCallback;
    private Geocoder geocoder;
    private List<Address> addresses;
    private BodyStatusRepo bodyStatusRepo;
    private PreferenceManager preferenceManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, null, false);
        binding.setHome(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        init(view);
        super.onViewCreated(view, savedInstanceState);
    }

    private void init(View view) {
        preferenceManager = new PreferenceManager(getContext());
        geocoder = new Geocoder(getActivity(), Locale.getDefault());
        // Create the location request to start receiving updates
        mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(UPDATE_INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
        fusedLocation = LocationServices.getFusedLocationProviderClient(getActivity());

        commonUtils = new CommonUtils(getContext());
        labeledSwitch = view.findViewById(R.id.lbSwitch);
        labeledSwitch.setOnToggledListener((toggleableView, isOn) -> {
            if (isOn) {
                binding.tvStatus.setText("Online");
                binding.tvStatus.setTextColor(getActivity().getResources().getColor(R.color.green));
                binding.lbSwitch.setColorOn(getActivity().getResources().getColor(R.color.green));
                getCurrentLocation();
            } else {
                binding.tvStatus.setText("Offline");
                binding.tvStatus.setTextColor(getActivity().getResources().getColor(R.color.color_primary));
                binding.lbSwitch.setColorOn(getActivity().getResources().getColor(R.color.color_primary));
                stopLocationServices();
            }
        });
    }

    private void getCurrentLocation() {
        try {
            // Create LocationSettingsRequest object using location request
            LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
            builder.addLocationRequest(mLocationRequest);
            LocationSettingsRequest locationSettingsRequest = builder.build();
            // Check whether location settings are satisfied
            // https://developers.google.com/android/reference/com/google/android/gms/location/SettingsClient
            SettingsClient settingsClient = LocationServices.getSettingsClient(getActivity());
            settingsClient.checkLocationSettings(locationSettingsRequest);
            // new Google API SDK v11 uses getFusedLocationProviderClient(this)

            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
             mLocationCallback = new LocationCallback(){
                @Override
                public void onLocationResult(LocationResult locationResult) {
                    for (Location location : locationResult.getLocations()) {
                        onLocationChanged(location);
                    }
                };
            };
            if(mLocationCallback!=null){
                fusedLocation.requestLocationUpdates(mLocationRequest,mLocationCallback,Looper.myLooper());
            }
       }catch (Exception e){
           commonUtils.toaster(e.getMessage());
       }
    }
    public void onLocationChanged(Location location) {
        // New location has now been determined
        String msg = "Updated Location: " +
                Double.toString(location.getLatitude()) + "," +
                Double.toString(location.getLongitude());
        try {
            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
        } catch (IOException e) {
            e.printStackTrace();
        }

        String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
        String city = addresses.get(0).getLocality();
        String state = addresses.get(0).getAdminArea();
        String country = addresses.get(0).getCountryName();
        String postalCode = addresses.get(0).getPostalCode();
        String knownName = addresses.get(0).getFeatureName();
        binding.tvLat.setText(location.getLatitude()+"");
        binding.tvLong.setText(location.getLongitude()+"");
        binding.tvAddressLine.setSelected(true);
        binding.tvAddressLine.setText(address);
        binding.tvCountry.setText(country);
        binding.tvPostalCode.setText(postalCode);
        binding.tvTrackId.setText(knownName);
        String lat=String.valueOf(location.getLatitude());
        String log=String.valueOf(location.getLongitude());
        if(preferenceManager!=null){
            bodyStatusRepo=new BodyStatusRepo(getActivity(),
                    preferenceManager.getData("token"),
                    preferenceManager.getData("id"),
                    preferenceManager.getData("first_name"),
                    preferenceManager.getData("last_name"),
                    preferenceManager.getData("employee_id"),
                    preferenceManager.getData("email"),
                    preferenceManager.getData("phone"),
                    preferenceManager.getData("company_name"),
                    lat,log,address,city,state,country,postalCode,knownName);
        }
    }
    private void stopLocationServices(){
        try{
            if(fusedLocation!=null && mLocationCallback!=null){
                fusedLocation.removeLocationUpdates(mLocationCallback);
                commonUtils.toaster("Location Access-Service Stopped");
            }
        }catch (Exception e){
            commonUtils.toaster(e.getMessage());
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        stopLocationServices();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        stopLocationServices();
    }
}
