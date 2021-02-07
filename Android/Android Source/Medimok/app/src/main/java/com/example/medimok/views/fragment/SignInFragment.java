package com.example.medimok.views.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import com.example.medimok.R;
import com.example.medimok.apiservice.ApiServices;
import com.example.medimok.apiservice.RetrofitService;
import com.example.medimok.databinding.FragmentSigninBinding;
import com.example.medimok.interfaces.SignInSignUpHandler;
import com.example.medimok.models.localmodel.SigInModel;
import com.example.medimok.models.repomodel.SignInRepoModel;
import com.example.medimok.preference.PreferenceManager;
import com.example.medimok.utils.CommonUtils;
import com.example.medimok.views.activity.MainActivity;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInFragment extends Fragment {
    private FragmentSigninBinding binding;
    private SignInSignUpHandler handler;
    private CommonUtils commonUtils;
    private SigInModel sigInModel;
    private ApiServices apiServices;
    private PreferenceManager preferenceManager;
    private String TAG=SignInFragment.class.getName();
    public SignInFragment(SignInSignUpHandler handler){
        this.handler=handler;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_signin,null,false);
        sigInModel=new SigInModel();
        binding.setSignIn(this);
        binding.setSingInModel(sigInModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        onBacker();
        apiServices=new RetrofitService().getService().create(ApiServices.class);
        preferenceManager=new PreferenceManager(getActivity().getApplicationContext());
        commonUtils=new CommonUtils(getActivity());
        super.onViewCreated(view, savedInstanceState);
    }

    private void onBacker() {
        binding.toolbar.imgBack.setOnClickListener(v ->
                handler.backer("signIn")
        );
    }
    public void newRegister(){
        handler.newRegister("signUp");
    }
    public void submit(){
        if(validation(sigInModel.getRegisterno(),sigInModel.getPassword())){
            hideKeyboard(getActivity());
            apiHitter(sigInModel);
        }
    }
    private boolean validation(String regno,String password){
        boolean result=false;
        if(!regno.equals("")){
            if(!password.equals("")){
                if(regno.length()!=10){
                    commonUtils.toaster("10-digit Employee-Id required");
                }
                else {
                    if(password.length()>=8){
                        result=true;
                    }
                    else {
                        commonUtils.toaster("Password min 8-digit required");
                    }
                }
            }
            else {
                commonUtils.toaster("password required");
            }
        }
        else {
            commonUtils.toaster("employee id required");
        }
        return result;
    }
    private void apiHitter(SigInModel sigInModel){
        try{
            commonUtils.showLoader();
            Call<SignInRepoModel> signInRepo=apiServices.getLogin(sigInModel);
            signInRepo.enqueue(new Callback<SignInRepoModel>() {
                @Override
                public void onResponse(Call<SignInRepoModel> call, Response<SignInRepoModel> response) {
                    commonUtils.hideLoader();
                    if(response!=null && response.body()!=null){
                        if(response.body().getStatus()){
                            SignInRepoModel repoModel=response.body();
                            preferenceManager.setData("id",repoModel.getData().getResult().get_id());
                            preferenceManager.setData("first_name",repoModel.getData().getResult().getFirstname());
                            preferenceManager.setData("last_name",repoModel.getData().getResult().getLastname());
                            preferenceManager.setData("email",repoModel.getData().getResult().getEmail());
                            preferenceManager.setData("phone",repoModel.getData().getResult().getPhone());
                            preferenceManager.setData("employee_id",repoModel.getData().getResult().getRegisterno());
                            preferenceManager.setData("company_name",repoModel.getData().getResult().getCompanyname());
                            preferenceManager.setData("token",repoModel.getData().getToken());
                            preferenceManager.setData("login","success");
                            commonUtils.toaster("Login Success");
                            new Handler().postDelayed(() -> {
                                Intent intent=new Intent(getActivity(), MainActivity.class);
                                startActivity(intent);
                                getActivity().finish();
                            },1000);
                        }
                        else {
                            commonUtils.toaster("Network-Error try again");
                        }
                    }
                    else {
                        try {
                            JSONObject jObjError = new JSONObject(response.errorBody().string());
                            commonUtils.toaster(jObjError.getJSONObject("error").
                                    getString("message").
                                    replace("/", "").replace("", "").toUpperCase());
                        } catch (Exception e) {
                            commonUtils.toaster(e.getMessage());
                        }
                    }
                }

                @Override
                public void onFailure(Call<SignInRepoModel> call, Throwable t) {
                    commonUtils.log(TAG,t.getMessage());
                    commonUtils.toaster(t.getMessage());
                    commonUtils.hideLoader();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
