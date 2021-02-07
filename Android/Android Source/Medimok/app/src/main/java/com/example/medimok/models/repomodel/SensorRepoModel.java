package com.example.medimok.models.repomodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SensorRepoModel {

    @Expose
    @SerializedName("data")
    private List<Data> data;
    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("status")
    private boolean status;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static class Data {
        @Expose
        @SerializedName("registerno")
        private String registerno;
        @Expose
        @SerializedName("phone")
        private String phone;
        @Expose
        @SerializedName("longitude")
        private String longitude;
        @Expose
        @SerializedName("latitude")
        private String latitude;
        @Expose
        @SerializedName("lastname")
        private String lastname;
        @Expose
        @SerializedName("id")
        private String id;
        @Expose
        @SerializedName("firstname")
        private String firstname;
        @Expose
        @SerializedName("email")
        private String email;
        @Expose
        @SerializedName("companyname")
        private String companyname;
        @Expose
        @SerializedName("_id")
        private String _id;
        @Expose
        @SerializedName("update")
        private String update;
        @Expose
        @SerializedName("block_key_two")
        private String block_key_two;
        @Expose
        @SerializedName("block_key_one")
        private String block_key_one;
        @Expose
        @SerializedName("anxiety")
        private String anxiety;
        @Expose
        @SerializedName("headaches")
        private String headaches;
        @Expose
        @SerializedName("sugar")
        private String sugar;
        @Expose
        @SerializedName("depression")
        private String depression;
        @Expose
        @SerializedName("asthma")
        private String asthma;
        @Expose
        @SerializedName("cardiogram")
        private String cardiogram;
        @Expose
        @SerializedName("oxygen")
        private String oxygen;
        @Expose
        @SerializedName("cholesterol")
        private String cholesterol;
        @Expose
        @SerializedName("heartRate")
        private String heartRate;
        @Expose
        @SerializedName("glucose")
        private String glucose;
        @Expose
        @SerializedName("respiration")
        private String respiration;
        @Expose
        @SerializedName("bloodPressure")
        private String bloodPressure;
        @Expose
        @SerializedName("bodyTemperature")
        private String bodyTemperature;
        @Expose
        @SerializedName("knownName")
        private String knownName;
        @Expose
        @SerializedName("postalcode")
        private String postalcode;
        @Expose
        @SerializedName("county")
        private String county;
        @Expose
        @SerializedName("state")
        private String state;
        @Expose
        @SerializedName("city")
        private String city;
        @Expose
        @SerializedName("address")
        private String address;

        public String getRegisterno() {
            return registerno;
        }

        public void setRegisterno(String registerno) {
            this.registerno = registerno;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCompanyname() {
            return companyname;
        }

        public void setCompanyname(String companyname) {
            this.companyname = companyname;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getUpdate() {
            return update;
        }

        public void setUpdate(String update) {
            this.update = update;
        }

        public String getBlock_key_two() {
            return block_key_two;
        }

        public void setBlock_key_two(String block_key_two) {
            this.block_key_two = block_key_two;
        }

        public String getBlock_key_one() {
            return block_key_one;
        }

        public void setBlock_key_one(String block_key_one) {
            this.block_key_one = block_key_one;
        }

        public String getAnxiety() {
            return anxiety;
        }

        public void setAnxiety(String anxiety) {
            this.anxiety = anxiety;
        }

        public String getHeadaches() {
            return headaches;
        }

        public void setHeadaches(String headaches) {
            this.headaches = headaches;
        }

        public String getSugar() {
            return sugar;
        }

        public void setSugar(String sugar) {
            this.sugar = sugar;
        }

        public String getDepression() {
            return depression;
        }

        public void setDepression(String depression) {
            this.depression = depression;
        }

        public String getAsthma() {
            return asthma;
        }

        public void setAsthma(String asthma) {
            this.asthma = asthma;
        }

        public String getCardiogram() {
            return cardiogram;
        }

        public void setCardiogram(String cardiogram) {
            this.cardiogram = cardiogram;
        }

        public String getOxygen() {
            return oxygen;
        }

        public void setOxygen(String oxygen) {
            this.oxygen = oxygen;
        }

        public String getCholesterol() {
            return cholesterol;
        }

        public void setCholesterol(String cholesterol) {
            this.cholesterol = cholesterol;
        }

        public String getHeartRate() {
            return heartRate;
        }

        public void setHeartRate(String heartRate) {
            this.heartRate = heartRate;
        }

        public String getGlucose() {
            return glucose;
        }

        public void setGlucose(String glucose) {
            this.glucose = glucose;
        }

        public String getRespiration() {
            return respiration;
        }

        public void setRespiration(String respiration) {
            this.respiration = respiration;
        }

        public String getBloodPressure() {
            return bloodPressure;
        }

        public void setBloodPressure(String bloodPressure) {
            this.bloodPressure = bloodPressure;
        }

        public String getBodyTemperature() {
            return bodyTemperature;
        }

        public void setBodyTemperature(String bodyTemperature) {
            this.bodyTemperature = bodyTemperature;
        }

        public String getKnownName() {
            return knownName;
        }

        public void setKnownName(String knownName) {
            this.knownName = knownName;
        }

        public String getPostalcode() {
            return postalcode;
        }

        public void setPostalcode(String postalcode) {
            this.postalcode = postalcode;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
