package com.example.medimok.views.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.medimok.R;
import com.example.medimok.broadcast.NetworkBroadCast;
import com.example.medimok.models.localmodel.NetworkModel;
import com.example.medimok.utils.CommonUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class BaseActivity extends AppCompatActivity {
    private int delay=3000;
    private NetworkBroadCast networkBroadCast;
    private IntentFilter intentFilter;
    private CommonUtils commonUtils;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        init();
        super.onCreate(savedInstanceState);
    }
    public void activityChanger(Activity fromActivity,Object toActivity){
        new Handler().postDelayed(() -> {
          startActivity(new Intent(fromActivity,toActivity.getClass()));
          finish();
        },delay);
    }

    private void init(){
        try{
            commonUtils=new CommonUtils(this,200);
            networkBroadCast = new NetworkBroadCast();
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void activityChangerImmediate(Activity fromActivity,Object toActivity){
        new Handler().postDelayed(() -> {
            startActivity(new Intent(fromActivity,toActivity.getClass()));
            finish();
        },100);
    }

    public void loadFragment(Fragment fragment,int fragmentId){
        try{
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
            fragmentTransaction.replace(fragmentId, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            if (!EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().register(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        registerReceiver(networkBroadCast, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            if (EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().unregister(this);
            }
            unregisterReceiver(networkBroadCast);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /*todo network listener*/
    @Subscribe
    public void networkState(NetworkModel networkModel) {
        /*todo connect =1 disconnect =2*/
        if (networkModel != null) {
            switch (networkModel.getCount()) {
                case 0:
                    /*todo network disconnect*/
                    commonUtils.showNetwork();
                   // commonUtils.snackBar(coordinatorlayout, "Network Offline", 1, getApplicationContext());
                    break;
                case 1:
                    /*todo network connect*/
                    commonUtils.hideNetwork();
                  //  commonUtils.snackBar(coordinatorlayout, "Network Online", 0, getApplicationContext());
                    break;
            }
        }
    }
}
