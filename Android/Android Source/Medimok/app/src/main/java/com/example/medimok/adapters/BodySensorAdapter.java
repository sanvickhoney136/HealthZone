package com.example.medimok.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medimok.R;
import com.example.medimok.models.localmodel.BodySensorModel;

import java.util.List;

public class BodySensorAdapter extends RecyclerView.Adapter<BodySensorAdapter.ViewHolder> {
    private List<BodySensorModel> bodySensorModel;
    public BodySensorAdapter(List<BodySensorModel> bodySensorModel){
        this.bodySensorModel=bodySensorModel;
    }

    @NonNull
    @Override
    public BodySensorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_sensor_report,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BodySensorAdapter.ViewHolder holder, int position) {
     try{

     }catch (Exception e){
         e.printStackTrace();
     }
    }

    @Override
    public int getItemCount() {
        return bodySensorModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgContent;
        TextView tvContent,tvHead;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgContent=itemView.findViewById(R.id.imgPicture);
            tvContent=itemView.findViewById(R.id.tvContent);
            tvHead=itemView.findViewById(R.id.tvReport);
        }
    }
}
