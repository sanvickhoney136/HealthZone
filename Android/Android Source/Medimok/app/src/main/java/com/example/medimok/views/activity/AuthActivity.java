package com.example.medimok.views.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.medimok.R;
import com.example.medimok.databinding.ActivityAuthenticationBinding;
import com.example.medimok.interfaces.SignInSignUpHandler;
import com.example.medimok.utils.CommonUtils;
import com.example.medimok.views.fragment.SignInFragment;
import com.example.medimok.views.fragment.SignUpFragment;

public class AuthActivity extends BaseActivity implements SignInSignUpHandler {
    private ActivityAuthenticationBinding binding;
    private CommonUtils commonUtils;
    private boolean onBacker=false;
    private Context context;
    private String TAG=AuthActivity.class.getName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_authentication);
        binding.setAuth(this);
        context=getApplicationContext();
        commonUtils=new CommonUtils(getApplicationContext());
    }
    public void signIn(){
        try{
            loadFragment(new SignInFragment(this),R.id.frameLayout);
        }catch (Exception e){
           commonUtils.log(TAG,e.getMessage());
        }
    }
    public void signUp(){
        try{
         loadFragment(new SignUpFragment(this),R.id.frameLayout);
        }catch (Exception e){
            commonUtils.log(TAG,e.getMessage());
        }
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()==0){
            if (onBacker) {
                this.finish();
            } else {
                commonUtils.toaster("Press One More Time to Exit");
                //commonUtils.snackBar(binding.relayHeader,"Press One More Time to Exit",1,getApplicationContext());
                onBacker = true;
            }
        }
        else {
            closeFragment();
        }
    }

    @Override
    public void newRegister(String page) {
        switch (page){
            case "signIn":
                signIn();
                break;
            case "signUp":
                signUp();
                break;
        }
    }

    @Override
    public void backer(String page) {
        closeFragment();
    }
    private void closeFragment(){
        int fragCount=getSupportFragmentManager().getBackStackEntryCount();
        for(int i=0;i<fragCount;i++){
            getSupportFragmentManager().popBackStackImmediate();
        }
    }
}
