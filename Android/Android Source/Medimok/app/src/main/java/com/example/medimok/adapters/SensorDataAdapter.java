package com.example.medimok.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medimok.databinding.LayoutSensorDetailsBinding;
import com.example.medimok.databinding.LayoutSettingsBinding;
import com.example.medimok.models.repomodel.SensorRepoModel;

import java.util.List;

public class SensorDataAdapter extends RecyclerView.Adapter<SensorDataAdapter.ViewHolder> {
    private List<SensorRepoModel.Data> repoModel;
    private Context context;
    public SensorDataAdapter(List<SensorRepoModel.Data> repoModel){
        this.repoModel=repoModel;
    }
    @NonNull
    @Override
    public SensorDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        LayoutSensorDetailsBinding binding=LayoutSensorDetailsBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SensorDataAdapter.ViewHolder holder, int position) {
         try{
             holder.binding.tvDate.setText(repoModel.get(position).getUpdate());
             holder.binding.tvHeart.setText(repoModel.get(position).getHeartRate()+" / 220");
             holder.binding.tvBloodPressure.setText(repoModel.get(position).getBloodPressure()+" / 160");
             holder.binding.tvColostrol.setText(repoModel.get(position).getCholesterol()+" / 240");
             holder.binding.tvGlucose.setText(repoModel.get(position).getGlucose()+" / 12");
             holder.binding.tvOxygen.setText(repoModel.get(position).getOxygen()+" / 140");
             holder.binding.tvSugar.setText(repoModel.get(position).getSugar()+" / 10");
         }catch (Exception e){
             e.printStackTrace();
         }
    }

    @Override
    public int getItemCount() {
        return repoModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LayoutSensorDetailsBinding binding;
        public ViewHolder(@NonNull LayoutSensorDetailsBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
