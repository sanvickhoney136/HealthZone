package com.example.medimok.validation;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.medimok.models.localmodel.SigUpModel;
import com.example.medimok.utils.CommonUtils;

public class SignUpValidation {
    public Context context;
    public CommonUtils commonUtils;

    public SignUpValidation(Context context) {
        this.context = context;
        this.commonUtils = new CommonUtils(context);
    }

    public boolean getModel(SigUpModel sigUpModel) {
        boolean result = false;
        if (sigUpModel.getFirstName().equals("")) {
            commonUtils.toaster("First Name Required");
        } else {
            if (sigUpModel.getLastName().equals("")) {
                commonUtils.toaster("Last Name Required");
            } else {
                if (sigUpModel.getEmail().equals("")) {
                    commonUtils.toaster("Email Required");
                } else {
                    if (sigUpModel.getPhone().equals("")) {
                        commonUtils.toaster("Phone Number Required");
                    } else {
                        if (sigUpModel.getCompanyName().equals("")) {
                            commonUtils.toaster("Company Name Required");
                        } else {
                            if (sigUpModel.getEmployeeId().equals("")) {
                                commonUtils.toaster("Employee Id Required");
                            } else {
                                if (sigUpModel.getPassword().equals("")) {
                                    commonUtils.toaster("Password Required");
                                } else {
                                    if(sigUpModel.getFirstName().length()>=4){
                                       if(sigUpModel.getLastName().length()>=4){
                                           if (sigUpModel.getPhone().length() == 10) {
                                               if (sigUpModel.getEmployeeId().length() == 10) {
                                                   if (sigUpModel.getPassword().length() >= 8) {
                                                       result=true;
                                                   }
                                                   else {
                                                       commonUtils.toaster("Password min 8-digit required");
                                                   }
                                               }
                                               else {
                                                   commonUtils.toaster("10-digit Employee Id required");
                                               }
                                           }
                                           else {
                                               commonUtils.toaster("10 digit phone number required");
                                           }
                                       }
                                       else {
                                           commonUtils.toaster("Last Name min 4-character");
                                       }
                                    }
                                    else{
                                        commonUtils.toaster("First Name min 4-character");
                                    }

//                                    else{
//                                        result=true;
//                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
