package com.example.medimok.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.medimok.R;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONObject;

public class CommonUtils {

    private Context context;
    private LayoutInflater inflater;
    private Activity activity;
    private AlertDialog alertDialog,alertDialogNetwork;
    private AlertDialog.Builder builder,builderNetwork;

    public CommonUtils(Activity activity){
        this.activity=activity;
        this.context=activity;
        inflater=activity.getLayoutInflater();
        builder = new AlertDialog.Builder(activity, R.style.CustomDialog);
        inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.layout_progressloader, null));
        alertDialog = builder.create();
        alertDialog.setCancelable(false);
    }

    public CommonUtils(Activity activity,int state){
        this.activity=activity;
        inflater=activity.getLayoutInflater();
        builderNetwork = new AlertDialog.Builder(activity, R.style.myFullscreenAlertDialogStyle);
        inflater = activity.getLayoutInflater();
        builderNetwork.setView(inflater.inflate(R.layout.layout_nointernet, null));
        alertDialogNetwork = builderNetwork.create();
        alertDialogNetwork.setCancelable(false);
    }


    public CommonUtils(Context context){
        this.context=context;
    }
    public void toast(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
    public void toaster(String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
    public void log(String TAG,String message){
        Log.e(TAG,message);
    }

    public void jsonParsingError(String message){
        try {
            JSONObject jObjError = new JSONObject(message);
            Toast.makeText(context,jObjError.getJSONObject("error").getString("message"),Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    public void showLoader(){
        try{
            if(alertDialog!=null){
               alertDialog.show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void hideLoader(){
        try{
            if(alertDialog!=null){
              alertDialog.setCancelable(true);
              alertDialog.hide();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void snackBar(RelativeLayout layout, String message, int state, Context context){
        Snackbar snackbar=Snackbar.make(layout,message,Snackbar.LENGTH_SHORT);
        View viewer = snackbar.getView();
        if(state==0){
            viewer.setBackgroundColor(context.getResources().getColor(R.color.green));
        }
        else{
            viewer.setBackgroundColor(context.getResources().getColor(R.color.color_secondary));
            snackbar.setAction("Dismiss",view -> {
                snackbar.dismiss();
            });
        }
        snackbar.setActionTextColor(Color.WHITE);
        snackbar.setDuration(2000);
        snackbar.show();
    }
    public void showNetwork(){
        if(alertDialogNetwork.isShowing()){
            alertDialogNetwork.hide();
            alertDialogNetwork.show();
        }
        else {
            alertDialogNetwork.show();
        }
        alertDialogNetwork.setCancelable(false);
    }
    public void hideNetwork(){
        try{
            if(alertDialogNetwork!=null){
                alertDialogNetwork.setCancelable(true);
                alertDialogNetwork.hide();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
