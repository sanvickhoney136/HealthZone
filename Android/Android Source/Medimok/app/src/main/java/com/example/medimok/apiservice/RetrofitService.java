package com.example.medimok.apiservice;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
  private Retrofit retrofit;
  private String baseUrl="https://medimok-m.herokuapp.com/";
  public Retrofit getService(){
      HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
      loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      OkHttpClient client =  new OkHttpClient.Builder()
              .connectTimeout(60, TimeUnit.SECONDS)
              .readTimeout(60, TimeUnit.SECONDS)
              .writeTimeout(60, TimeUnit.SECONDS)
              .addInterceptor(loggingInterceptor)//third, log at the end
              .build();
      if(retrofit==null){
          retrofit = new Retrofit.Builder()
                  .baseUrl(baseUrl)
                  .client(client)
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();
      }
      return retrofit;
  }
}
