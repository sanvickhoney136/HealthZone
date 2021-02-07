package com.example.medimok.views.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.medimok.R;
import com.example.medimok.databinding.LayoutSettingsBinding;
import com.example.medimok.preference.PreferenceManager;
import com.example.medimok.utils.CommonUtils;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class SettingFragment extends BottomSheetDialogFragment {
    private LayoutSettingsBinding binding;
    private settingHandler settingHandler;
    public SettingFragment(settingHandler handler){
        this.settingHandler=handler;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.layout_settings,null,false);
        binding.setSettings(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public void account(){
        settingHandler.setting("profile");
    }
    public void logout(){
        settingHandler.setting("logout");
    }
    public void privacy(){
        settingHandler.setting("privacy");
    }
    public void about(){
        settingHandler.setting("about");
    }
    public void report(){
        settingHandler.setting("report");
    }
    public interface settingHandler{
         void setting(String content);
    }
}
