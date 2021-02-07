package com.example.medimok.views.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import com.example.medimok.R;
import com.example.medimok.databinding.ActivitySplashBinding;
import com.example.medimok.preference.PreferenceManager;

public class Splash extends BaseActivity{
    private ActivitySplashBinding binding;
    private PreferenceManager preferenceManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_splash);
        binding.setSplash(this);
        checkLogin();
    }
    private void checkLogin(){
        preferenceManager=new PreferenceManager(getApplicationContext());
        if(preferenceManager.getData("login").equals("success")){
            activityChanger(this,new MainActivity());
        }
        else{
            activityChanger(this,new AuthActivity());
        }
    }
}
