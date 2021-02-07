package com.example.medimok.views.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.medimok.R;
import com.example.medimok.adapters.SensorDataAdapter;
import com.example.medimok.apiservice.ApiServices;
import com.example.medimok.apiservice.RetrofitService;
import com.example.medimok.databinding.ActivitySensorDetailsBinding;
import com.example.medimok.databinding.ActivitySplashBinding;
import com.example.medimok.models.repomodel.SensorRepoModel;
import com.example.medimok.preference.PreferenceManager;
import com.example.medimok.utils.CommonUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SensorReportActivity extends BaseActivity {
    private ActivitySensorDetailsBinding binding;
    private CommonUtils commonUtils;
    private ApiServices apiServices;
    private PreferenceManager preferenceManager;
    public SensorDataAdapter adapter;
    private String TAG = SensorReportActivity.class.getName();
    public List<SensorRepoModel.Data> sensorData = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sensor_details);
        binding.setModel(this);
        init();
    }

    private void init() {
        commonUtils = new CommonUtils(this);
        apiServices = new RetrofitService().getService().create(ApiServices.class);
        preferenceManager = new PreferenceManager(this);
        binding.toolbar.imgBack.setOnClickListener(v -> {
            finish();
        });
        binding.swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                apiHitter();
                binding.swipeLayout.setRefreshing(false);
            }
        });
        setAdapter();
    }

    private void setAdapter() {
        adapter = new SensorDataAdapter(sensorData);
        binding.recList.setAdapter(adapter);
        apiHitter();
    }

    private void apiHitter() {
        try {
            commonUtils.showLoader();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("id", preferenceManager.getData("id"));
            hashMap.put("registerno", preferenceManager.getData("employee_id"));
            Call<SensorRepoModel> sensorRepoModelCall =
                    apiServices.getSensorReport(preferenceManager.getData("token"), hashMap);
            sensorRepoModelCall.enqueue(new Callback<SensorRepoModel>() {
                @Override
                public void onResponse(Call<SensorRepoModel> call, Response<SensorRepoModel> response) {
                    commonUtils.hideLoader();
                    if (response != null && response.body() != null) {
                        sensorData.clear();
                        sensorData.addAll(response.body().getData());
                        adapter.notifyDataSetChanged();
                        if(sensorData.size()>0){
                            binding.tvRecords.setText("Total Records :"+sensorData.size());
                            binding.linerNoData.setVisibility(View.GONE);
                        }
                        else {
                            binding.tvRecords.setText("");
                            binding.linerNoData.setVisibility(View.VISIBLE);
                        }

                    }
                    else{
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
                public void onFailure(Call<SensorRepoModel> call, Throwable t) {
                    commonUtils.hideLoader();
                    commonUtils.log(TAG, t.getMessage());
                    commonUtils.toaster(t.getMessage());
                }
            });
        } catch (Exception e) {
            commonUtils.hideLoader();
            commonUtils.log(TAG, e.getMessage());
        }
    }
}
