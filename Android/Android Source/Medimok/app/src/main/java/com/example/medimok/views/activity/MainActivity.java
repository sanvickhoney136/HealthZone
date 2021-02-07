package com.example.medimok.views.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.medimok.R;
import com.example.medimok.adapters.ViewPagerAdapter;
import com.example.medimok.databinding.ActivityMainBinding;
import com.example.medimok.preference.PreferenceManager;
import com.example.medimok.utils.CommonUtils;
import com.example.medimok.views.fragment.HealthFragment;
import com.example.medimok.views.fragment.HomeFragment;
import com.example.medimok.views.fragment.ProfileFragment;
import com.example.medimok.views.fragment.SettingFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener, SettingFragment.settingHandler, ProfileFragment.profileChanger {
    private ActivityMainBinding activityMainBinding;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<String> tabHeader = new ArrayList<>();
    private PreferenceManager preferenceManager;
    private CommonUtils commonUtils;
    private SettingFragment settingFragment;
    private String TAG = MainActivity.class.getName();
    private int LOCATION_REQUREST_CODE = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setBinding(this);
        init();
    }

    private void init() {
        commonUtils = new CommonUtils(getApplicationContext());
        preferenceManager = new PreferenceManager(getApplicationContext());
        String username = preferenceManager.getData("first_name") + "_" + preferenceManager.getData("last_name");
        if (!username.equals("")) {
            activityMainBinding.toolBar.imgTitle.setText("Hi! " + username);
        } else {
            activityMainBinding.toolBar.imgTitle.setText("Hi! ");
        }
        viewPager = activityMainBinding.viewPager;
        tabLayout = activityMainBinding.tabLayout;
        tabHeader.add("PROFILE");
        tabHeader.add("HOME");
        tabHeader.add("HEALTH");
        setAdapter();
        activityMainBinding.toolBar.imgSetting.setOnClickListener(this);
    }

    private void setAdapter() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        ArrayList<String> pageHeader = new ArrayList<>();
        List<Fragment> pageBody = new ArrayList<>();

        pageHeader.add("PROFILE");
        pageHeader.add("HOME");
        pageHeader.add("HEALTH");

        pageBody.add(new ProfileFragment(this));
        pageBody.add(new HomeFragment());
        pageBody.add(new HealthFragment());

        adapter.addPager(pageHeader, pageBody);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.imgSetting: {
                settingFragment = new SettingFragment(this);
                settingFragment.show(getSupportFragmentManager(), settingFragment.getTag());
                break;
            }
        }
    }

    @Override
    public void setting(String content) {
        settingFragment.dismiss();
        switch (content) {
            case "profile": {
                viewPager.setCurrentItem(0);
                break;
            }
            case "logout": {
                commonUtils.toaster("Account-Logout");
                preferenceManager.clearPreference();
                activityChangerImmediate(this, new Splash());
                break;
            }
            case "report":{
                startActivity(new Intent(MainActivity.this,SensorReportActivity.class));
                break;
            }
            case "privacy": {
                break;
            }
            case "about": {
                break;
            }
        }
    }

    @Override
    public void change(boolean condition) {
        if (condition) {
            String username = preferenceManager.getData("first_name") + "_" + preferenceManager.getData("last_name");
            if (!username.equals("")) {
                activityMainBinding.toolBar.imgTitle.setText("Hi! " + username);
            } else {
                activityMainBinding.toolBar.imgTitle.setText("Hi! ");
            }
        }
    }

    private void checkIfAlreadyhavePermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int result2 = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE);
        if (result == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED) {
           // commonUtils.toaster("Permission already granted");
        } else {
            askLocationPermission();
        }
    }

    private void askLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.ACCESS_NETWORK_STATE)) {
                Log.d(TAG, "ACCESS_FINE_LOCATION");
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_NETWORK_STATE},
                        LOCATION_REQUREST_CODE);
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_NETWORK_STATE},
                        LOCATION_REQUREST_CODE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == LOCATION_REQUREST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (grantResults.length > 0 && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                }
                else {
                    commonUtils.toaster("network access-permission required");
                    finish();
                }
            } else {
                commonUtils.toaster("location access-permission required");
                finish();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkIfAlreadyhavePermission();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}