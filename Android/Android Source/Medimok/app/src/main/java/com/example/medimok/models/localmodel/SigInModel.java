package com.example.medimok.models.localmodel;

public class SigInModel {
    private String registerno="";
    private String password="";

    public SigInModel(){

    }
    public SigInModel(String registerno, String password) {
        this.registerno = registerno;
        this.password = password;
    }

    public String getRegisterno() {
        return registerno;
    }

    public void setRegisterno(String registerno) {
        this.registerno = registerno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
