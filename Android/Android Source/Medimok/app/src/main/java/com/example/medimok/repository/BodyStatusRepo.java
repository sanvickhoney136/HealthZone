package com.example.medimok.repository;

import android.content.Context;

import com.example.medimok.apiservice.ApiServices;
import com.example.medimok.apiservice.RetrofitService;
import com.example.medimok.models.localmodel.BodySensorModel;
import com.example.medimok.models.repomodel.BodySensorRepoModel;
import com.example.medimok.utils.CommonUtils;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BodyStatusRepo {
    private ApiServices apiServices;
    private String token;
    private BodySensorModel bodySensorModel;
    private Context context;
    private CommonUtils commonUtils;
    private Random random;
    private String TAG = BodyStatusRepo.class.getName();
    private String bodyTemperature = "0";
    private String bodyPressure = "0";
    private String respiration="0";
    private String glucose="0";
    private String heartRate="0";
    private String cholesterol="0";
    private String oxygen="0";
    private String cardiogram="0";
    private String asthma="0";
    private String sugar="0";
    private String depression="0";
    private String headaches="0";
    private String anxiety="0";

    private String id="0";
    private String firstname="";
    private String lastname="";
    private String employeeid="";
    private String email="";
    private String phone="";
    private String company;
    private String latitude="";
    private String longitude="";
    private String address="";
    private String city="";
    private String state="";
    private String county="";
    private String postalcode="";
    private String knownName="";

    public BodyStatusRepo(Context context,
                          String token,
                          String id,
                          String firstname,
                          String lastname,
                          String employeeid,
                          String email,
                          String phone,
                          String company,
                          String latitude,
                          String longitude,
                          String address,
                          String city,
                          String state,
                          String county,
                          String postalcode,
                          String knownName) {
        this.context = context;
        this.token=token;
        this.id=id;
        this.firstname=firstname;
        this.lastname=lastname;
        this.employeeid=employeeid;
        this.email=email;
        this.phone=phone;
        this.company=company;
        this.latitude=latitude;
        this.longitude=longitude;
        this.address=address;
        this.city=city;
        this.state=state;
        this.county=county;
        this.postalcode=postalcode;
        this.knownName=knownName;
        init();
    }

    private void init() {
        commonUtils = new CommonUtils(context);
        apiServices=new RetrofitService().getService().create(ApiServices.class);
        random = new Random();
        randomValueGenerator();
    }

    private void randomValueGenerator() {
        try {
            bodyTemperature = String.valueOf(random.nextInt(120 - 85 + 1) + 85);
            bodyPressure = String.valueOf(random.nextInt(180 - 60 + 1) + 60);

            respiration = String.valueOf(random.nextInt(35 - 10 + 1) + 10);
            glucose = String.valueOf(random.nextInt(10 - 2 + 1) + 2);

            heartRate = String.valueOf(random.nextInt(220 - 140 + 1) + 140);
            cholesterol = String.valueOf(random.nextInt(200 - 100 + 1) + 100);

            oxygen = String.valueOf(random.nextInt(120 - 80 + 1) + 80);
            cardiogram = String.valueOf(random.nextInt(220 - 140 + 1) + 140);

            asthma = String.valueOf(random.nextInt(60 - 10 + 1) + 10);
            sugar = String.valueOf(random.nextInt(10 - 2 + 1) + 2);

            depression = String.valueOf(random.nextInt(100 - 10 + 1) + 10);
            headaches = String.valueOf(random.nextInt(100 - 10 + 1) + 10);

            anxiety = String.valueOf(random.nextInt(120 - 40 + 1) + 40);

            bodySensorModel=new BodySensorModel(
                    id,
                    firstname,
                    lastname,
                    employeeid,
                    email,
                    phone,
                    company,
                    latitude,
                    longitude,
                    address,
                    city,
                    state,
                    county,
                    postalcode,
                    knownName,
                    bodyTemperature,
                    bodyPressure,
                    respiration,
                    glucose,
                    heartRate,
                    cholesterol,
                    oxygen,
                    cardiogram,
                    asthma,
                    depression,
                    sugar,
                    headaches,
                    anxiety);
            EventBus.getDefault().postSticky(bodySensorModel);
            apiHitter(bodySensorModel);
        } catch (Exception e) {
            commonUtils.log(TAG, e.getMessage());
        }
    }

    private void apiHitter(BodySensorModel bodySensorModel) {
        try {
         if(bodySensorModel!=null && apiServices!=null){
             Call<BodySensorRepoModel> repository=apiServices.uploadSensor(token,bodySensorModel);
             repository.enqueue(new Callback<BodySensorRepoModel>() {
                 @Override
                 public void onResponse(Call<BodySensorRepoModel> call, Response<BodySensorRepoModel> response) {
                     if(response!=null && response.body()!=null){
                         if(response.body().getStatus()){

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
                 public void onFailure(Call<BodySensorRepoModel> call, Throwable t) {
                     commonUtils.log(TAG,t.getMessage());
                     commonUtils.toaster(t.getMessage());
                 }
             });
         }
         else {

         }
        } catch (Exception e) {
            commonUtils.log(TAG, e.getMessage());
        }
    }
}
