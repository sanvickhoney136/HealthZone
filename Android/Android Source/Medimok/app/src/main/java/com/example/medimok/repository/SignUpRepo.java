package com.example.medimok.repository;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.medimok.apiservice.ApiServices;
import com.example.medimok.apiservice.RetrofitService;
import com.example.medimok.models.localmodel.SigUpModel;
import com.example.medimok.models.repomodel.SignUpRepoModel;
import com.example.medimok.utils.CommonUtils;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpRepo {
    private SigUpModel sigUpModel;
    private String TAG = SignUpRepo.class.getName();
    private MutableLiveData<SignUpRepoModel> liveData;
    private CommonUtils commonUtils;
    private Context context;
    private ApiServices apiServices;
    private Activity activity;

    public SignUpRepo(SigUpModel sigUpModel, Context cont, Activity activity) {
        this.sigUpModel = sigUpModel;
        this.context = cont;
        this.activity=activity;
        init();
    }

    private void init() {
        commonUtils = new CommonUtils(activity);
        apiServices = new RetrofitService().getService().create(ApiServices.class);
    }

    public LiveData<SignUpRepoModel> getSigUpModel() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
            apiHitter();
        }
        return liveData;
    }

    private void apiHitter() {
        try {
            if (sigUpModel != null) {
                commonUtils.showLoader();
                Call<SignUpRepoModel> repoModel = apiServices.getRegistration(sigUpModel);
                repoModel.enqueue(new Callback<SignUpRepoModel>() {
                    @Override
                    public void onResponse(Call<SignUpRepoModel> call, Response<SignUpRepoModel> response) {
                        commonUtils.hideLoader();
                        if (response != null && response.body() != null) {
                            if (response.body().getStatus()) {
                                liveData.setValue(response.body());
                            } else {
                                commonUtils.toast(context, response.body().getMessage());
                            }
                        } else {
                            try {
                                JSONObject jObjError = new JSONObject(response.errorBody().string());
                                commonUtils.toaster(jObjError.getJSONObject("error").
                                        getString("message").
                                        replace("/", "").replace("", "").toLowerCase());
                            } catch (Exception e) {
                                commonUtils.toaster(e.getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<SignUpRepoModel> call, Throwable t) {
                        commonUtils.toast(context, t.getMessage());
                        commonUtils.hideLoader();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
