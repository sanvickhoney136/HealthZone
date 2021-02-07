package com.example.medimok.views.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.medimok.R;
import com.example.medimok.databinding.FragmentSocialBinding;
import com.example.medimok.models.localmodel.BodySensorModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HealthFragment extends Fragment {
    private FragmentSocialBinding binding;
    private String datePattern="E, dd MMM yyyy HH:mm:ss z";
    private String timePattern = "HH:mm:ss";
    private SimpleDateFormat simpleDateFormat;
    private String currentDate="";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_social,null,false);
        binding.setSocial(this);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        init();
        super.onViewCreated(view, savedInstanceState);
    }
    private void init(){
        simpleDateFormat=new SimpleDateFormat(datePattern);
        currentDate=simpleDateFormat.format(new Date());
        binding.tvDate.setSelected(true);
        binding.tvDate.setText(currentDate);
    }

    @Subscribe
    public void getSensorReport(BodySensorModel bodySensorModel){
        try{
            binding.tvHeartReport.setText(bodySensorModel.getHeartRate()+" / 220");
            binding.tvBloodPressure.setText(bodySensorModel.getBloodPressure()+" / 160");
            binding.tvColostrol.setText(bodySensorModel.getCholesterol()+" / 240");
            binding.tvGlucose.setText(bodySensorModel.getGlucose()+" / 12");
            binding.tvOxygen.setText(bodySensorModel.getOxygen()+" / 140");
            binding.tvSugar.setText(bodySensorModel.getSugar()+" / 10");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

     void registerEventBus(){
        try{
            if(!EventBus.getDefault().isRegistered(this)){
                EventBus.getDefault().register(this);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
     void unregisterEventBus(){
        if(EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        registerEventBus();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unregisterEventBus();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterEventBus();
    }
}
