package com.example.medimok.apiservice;

import com.example.medimok.models.localmodel.BodySensorModel;
import com.example.medimok.models.localmodel.ProfileModel;
import com.example.medimok.models.localmodel.SigInModel;
import com.example.medimok.models.localmodel.SigUpModel;
import com.example.medimok.models.repomodel.BodySensorRepoModel;
import com.example.medimok.models.repomodel.SensorRepoModel;
import com.example.medimok.models.repomodel.SignInRepoModel;
import com.example.medimok.models.repomodel.SignUpRepoModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface ApiServices {

    @POST("employee/register")
    Call<SignUpRepoModel> getRegistration(@Body SigUpModel sigUpModel);

    @POST("employee/login")
    Call<SignInRepoModel> getLogin(@Body SigInModel sigInModel);

    @POST("employee/editprofile")
    Call<ProfileModel> getEditProfile(@Header("Authorization") String accessToken,
                                      @Body ProfileModel profileModel);
    @POST("employee/sensor")
    Call<BodySensorRepoModel> uploadSensor(@Header("Authorization") String accessToken,
                                           @Body BodySensorModel bodySensorModel);

    @FormUrlEncoded
    @POST("employee/medical")
    Call<SensorRepoModel> getSensorReport(@Header("Authorization") String accessToken,
                                       @FieldMap HashMap<String,String> params);
}
