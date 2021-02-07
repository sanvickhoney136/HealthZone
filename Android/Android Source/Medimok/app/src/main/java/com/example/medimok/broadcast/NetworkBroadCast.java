package com.example.medimok.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.medimok.models.localmodel.NetworkModel;

import org.greenrobot.eventbus.EventBus;

public class NetworkBroadCast extends BroadcastReceiver {
    private ConnectivityManager connectivityManager;
    private NetworkInfo networkInfo;
    private String TAG=NetworkBroadCast.class.getName();
    @Override
    public void onReceive(Context context, Intent intent) {
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean checker = networkInfo != null && networkInfo.isConnectedOrConnecting();
        try {
            if (checker) {
                if (Runtime.getRuntime().exec("ping -c 1 Google.com").waitFor() == 0) {
                    EventBus.getDefault().postSticky(new NetworkModel("connect", 1));
                } else {
                    EventBus.getDefault().postSticky(new NetworkModel("disconnect", 0));
                }
            } else {
                EventBus.getDefault().postSticky(new NetworkModel("disconnect", 0));
            }
        } catch (Exception e) {
            Log.d(TAG,e.getMessage());
        }
    }
}
