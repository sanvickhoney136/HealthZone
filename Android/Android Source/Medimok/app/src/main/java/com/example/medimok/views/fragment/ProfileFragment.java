package com.example.medimok.views.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.medimok.R;
import com.example.medimok.apiservice.ApiServices;
import com.example.medimok.apiservice.RetrofitService;
import com.example.medimok.databinding.FragmentProfileBinding;
import com.example.medimok.models.localmodel.ProfileModel;
import com.example.medimok.preference.PreferenceManager;
import com.example.medimok.utils.CommonUtils;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    private ProfileModel profileModel;
    private PreferenceManager preferenceManager;
    private CommonUtils commonUtils;
    private ApiServices apiServices;
    private String accessToken;
    private String TAG = ProfileFragment.class.getName();
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    private LayoutInflater inflater;
    private Activity activity;
    private EditText firstName, lastName, email, phone;
    private String strFirstName = "", strLastName = "", strEmail = "", strPhone = "";
    private Button btnSubmit;
    private profileChanger profileChanger;

    public ProfileFragment(profileChanger profileChanger){
        this.profileChanger=profileChanger;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, null, false);
        binding.setProfile(this);
        init();
        if (profileModel != null)
            binding.setProfileModel(profileModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void init() {
        activity = getActivity();
        commonUtils = new CommonUtils(getActivity());
        apiServices = new RetrofitService().getService().create(ApiServices.class);
        preferenceManager = new PreferenceManager(getContext());

        inflater = activity.getLayoutInflater();
        builder = new AlertDialog.Builder(activity, R.style.CustomDialog);
        inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.layout_editprofile, null));
        alertDialog = builder.create();
        alertDialog.setCancelable(true);
        profileModel = new ProfileModel(
                preferenceManager.getData("id"),
                preferenceManager.getData("first_name"),
                preferenceManager.getData("last_name"),
                preferenceManager.getData("email"),
                preferenceManager.getData("phone"),
                preferenceManager.getData("company_name"),
                preferenceManager.getData("employee_id"));
        accessToken = preferenceManager.getData("token");
    }

    public void editProfileBtn() {
        if (alertDialog != null) {
            alertDialog.show();
            firstName = (EditText) alertDialog.findViewById(R.id.edtFirstName);
            lastName = (EditText) alertDialog.findViewById(R.id.edtLastName);
            email = (EditText) alertDialog.findViewById(R.id.edtEmail);
            phone = (EditText) alertDialog.findViewById(R.id.edtPhone);
            btnSubmit = (Button) alertDialog.findViewById(R.id.btnSubmit);

            firstName.setText(profileModel.getFirstname());
            lastName.setText(profileModel.getLastname());
            email.setText(profileModel.getEmail());
            phone.setText(profileModel.getPhone());
            btnSubmit.setOnClickListener(v -> {
                strFirstName = firstName.getText().toString();
                strLastName = lastName.getText().toString();
                strEmail = email.getText().toString();
                strPhone = phone.getText().toString();
                if (validation()) {
                    profileModel.setFirstname(strFirstName);
                    profileModel.setLastname(strLastName);
                    profileModel.setEmail(strEmail);
                    profileModel.setPhone(strPhone);
                    editProfile(profileModel);
                }
            });
        }
    }

    private boolean validation() {
        boolean condition = false;
        if (strFirstName.equals("") && strLastName.equals("") && strEmail.equals("") && strPhone.equals("")) {
            commonUtils.toaster("All fields are empty");
        } else {
            if (!strFirstName.equals("")) {
                if (!strLastName.equals("")) {
                    if (!strEmail.equals("")) {
                        if (!strPhone.equals("")) {
                            condition = true;
                        } else {
                            commonUtils.toaster("phone number required");
                        }
                    } else {
                        commonUtils.toaster("email required");
                    }
                } else {
                    commonUtils.toaster("lastname required");
                }
            } else {
                commonUtils.toaster("firstname required");
            }
        }
        return condition;
    }

    public void editProfile(ProfileModel profileModel) {
        try {
            commonUtils.showLoader();
            Call<ProfileModel> getEditProfile = apiServices.getEditProfile(accessToken, profileModel);
            getEditProfile.enqueue(new Callback<ProfileModel>() {
                @Override
                public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {
                    commonUtils.hideLoader();
                    if (response != null && response.body() != null) {
                        alertDialog.hide();
                        commonUtils.toaster("Profile Updated Successfully...!");
                        preferenceManager.setData("first_name", response.body().getFirstname());
                        preferenceManager.setData("last_name", response.body().getLastname());
                        preferenceManager.setData("email", response.body().getEmail());
                        preferenceManager.setData("phone", response.body().getPhone());
                        ProfileModel profileModel = new ProfileModel(
                                preferenceManager.getData("id"),
                                preferenceManager.getData("first_name"),
                                preferenceManager.getData("last_name"),
                                preferenceManager.getData("email"),
                                preferenceManager.getData("phone"),
                                preferenceManager.getData("company_name"),
                                preferenceManager.getData("employee_id"));
                        binding.setProfileModel(profileModel);
                        profileChanger.change(true);
                    } else {
                        try {
                            commonUtils.toaster("Invalid Email & Contact");
//                            JSONObject jObjError = new JSONObject(response.errorBody().string());
//                            commonUtils.toaster(jObjError.getJSONObject("error").
//                                    getString("message").
//                                    replace("/", "").replace("", "").toUpperCase());
                        } catch (Exception e) {
                            //commonUtils.toaster(e.getMessage());
                            commonUtils.toaster("Invalid Email & Contact");
                        }
                    }
                }

                @Override
                public void onFailure(Call<ProfileModel> call, Throwable t) {
                    commonUtils.hideLoader();
                    commonUtils.log(TAG, t.getMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public interface profileChanger{
        void change(boolean condition);
    }
}
