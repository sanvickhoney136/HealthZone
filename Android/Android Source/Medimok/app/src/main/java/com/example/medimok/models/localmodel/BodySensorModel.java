package com.example.medimok.models.localmodel;

public class BodySensorModel {
    private String id;
    private String firstname;
    private String lastname;
    private String registerno;
    private String email;
    private String phone;
    private String companyname;
    private String latitude;
    private String longitude;
    private String address;
    private String city;
    private String state;
    private String county;
    private String postalcode;
    private String knownName;
    private String bodyTemperature;
    private String bloodPressure;
    private String respiration;
    private String glucose;
    private String heartRate;
    private String cholesterol;
    private String oxygen;
    private String cardiogram;
    private String asthma;
    private String depression;
    private String sugar;
    private String headaches;
    private String anxiety;

    public BodySensorModel(){}

    public BodySensorModel(String id, String firstname, String lastname,
                           String employeeid, String email, String phone,String company,
                           String latitude, String longitude, String address,
                           String city, String state, String county, String postalcode,
                           String knownName, String bodyTemperature, String bloodPressure,
                           String respiration, String glucose, String heartRate,
                           String cholesterol, String oxygen, String cardiogram,
                           String asthma, String depression, String sugar, String headaches, String anxiety) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.registerno = employeeid;
        this.email = email;
        this.phone = phone;
        this.companyname=company;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.city = city;
        this.state = state;
        this.county = county;
        this.postalcode = postalcode;
        this.knownName = knownName;
        this.bodyTemperature = bodyTemperature;
        this.bloodPressure = bloodPressure;
        this.respiration = respiration;
        this.glucose = glucose;
        this.heartRate = heartRate;
        this.cholesterol = cholesterol;
        this.oxygen = oxygen;
        this.cardiogram = cardiogram;
        this.asthma = asthma;
        this.depression = depression;
        this.sugar = sugar;
        this.headaches = headaches;
        this.anxiety = anxiety;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRegisterno() {
        return registerno;
    }

    public void setRegisterno(String registerno) {
        this.registerno = registerno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getKnownName() {
        return knownName;
    }

    public void setKnownName(String knownName) {
        this.knownName = knownName;
    }

    public String getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(String bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getRespiration() {
        return respiration;
    }

    public void setRespiration(String respiration) {
        this.respiration = respiration;
    }

    public String getGlucose() {
        return glucose;
    }

    public void setGlucose(String glucose) {
        this.glucose = glucose;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public String getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(String cholesterol) {
        this.cholesterol = cholesterol;
    }

    public String getOxygen() {
        return oxygen;
    }

    public void setOxygen(String oxygen) {
        this.oxygen = oxygen;
    }

    public String getCardiogram() {
        return cardiogram;
    }

    public void setCardiogram(String cardiogram) {
        this.cardiogram = cardiogram;
    }

    public String getAsthma() {
        return asthma;
    }

    public void setAsthma(String asthma) {
        this.asthma = asthma;
    }

    public String getDepression() {
        return depression;
    }

    public void setDepression(String depression) {
        this.depression = depression;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getHeadaches() {
        return headaches;
    }

    public void setHeadaches(String headaches) {
        this.headaches = headaches;
    }

    public String getAnxiety() {
        return anxiety;
    }

    public void setAnxiety(String anxiety) {
        this.anxiety = anxiety;
    }
    //    Body temp             (min 90-110) (fever 95 = above)
//    Blood pressure        (min 60-160) (60-90 low pressure) (140 = above high pressure)
//    Respiration           (min 10-35)   (25 = above problem)
//    Glucose level         (min 2-10) (7 = above problem)
//    Heart rate             (min 140-200) (180 above problem)
//    Cholesterol level      (min 100-200)  (160 above problem)
//    Oxygen saturation      (min 85-120) (92% or lower problem)
//    Electro cardiogram     (min 140-200) (180 above problem)
//    Asthuma                (min 10-60) (20 below problem)
//    Sugar level            (min 1-10) (7 above sugar level problem)
//    Depression             (min 10-100) (70 above depression problem)
//    Headaches              (min 10-100) (80 above head problem)
//    Anxiety                (min 40-120) (100 above anixiety)
}
