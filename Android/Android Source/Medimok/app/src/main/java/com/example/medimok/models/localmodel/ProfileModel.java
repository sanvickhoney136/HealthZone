package com.example.medimok.models.localmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileModel {
    @Expose
    @SerializedName("registerno")
    private String registerno;
    @Expose
    @SerializedName("companyname")
    private String companyname;
    @Expose
    @SerializedName("phone")
    private String phone;
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("lastname")
    private String lastname;
    @Expose
    @SerializedName("firstname")
    private String firstname;
    @Expose
    @SerializedName("_id")
    private String _id;

    public ProfileModel(String _id,
                        String firstname,
                        String lastname,
                        String email,
                        String phone,
                        String companyname,
                        String registerno) {
        this.registerno = registerno;
        this.companyname = companyname;
        this.phone = phone;
        this.email = email;
        this.lastname = lastname;
        this.firstname = firstname;
        this._id = _id;
    }

    public String getRegisterno() {
        return registerno;
    }

    public void setRegisterno(String registerno) {
        this.registerno = registerno;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
