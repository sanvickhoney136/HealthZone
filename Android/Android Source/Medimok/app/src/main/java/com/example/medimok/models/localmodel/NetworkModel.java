package com.example.medimok.models.localmodel;

public class NetworkModel {
    String status;
    int count;
    public NetworkModel(String state,int cnt){
        this.status=state;
        this.count=cnt;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
