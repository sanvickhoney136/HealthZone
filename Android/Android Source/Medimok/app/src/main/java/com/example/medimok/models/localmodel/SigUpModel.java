package com.example.medimok.models.localmodel;

public class SigUpModel {
    private String firstname="";
    private String lastname="";
    private String email="";
    private String phone="";
    private String companyname="";
    private String registerno="";
    private String password="";

    public SigUpModel() {
    }

    public SigUpModel(String firstname, String lastname, String email, String phone, String companyname, String registerno, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.companyname = companyname;
        this.registerno = registerno;
        this.password = password;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
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

    public String getCompanyName() {
        return companyname;
    }

    public void setCompanyName(String companyName) {
        this.companyname = companyName;
    }

    public String getEmployeeId() {
        return registerno;
    }

    public void setEmployeeId(String employeeId) {
        this.registerno = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
