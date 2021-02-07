package com.example.medimok.viewmodels;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.medimok.models.localmodel.SigUpModel;
import com.example.medimok.models.repomodel.SignInRepoModel;
import com.example.medimok.models.repomodel.SignUpRepoModel;
import com.example.medimok.repository.SignUpRepo;
import com.example.medimok.validation.SignUpValidation;

import org.jetbrains.annotations.NotNull;

public class SignUpViewModel extends AndroidViewModel {
    private SigUpModel sigUpModel;
    private Context context;
    private SignUpRepo signUpRepo;
    public SignUpViewModel(@NotNull Application application, SigUpModel sigUpModel,Activity activity){
        super(application);
        this.sigUpModel=sigUpModel;
        this.context=application.getApplicationContext();
        signUpRepo=new SignUpRepo(sigUpModel,context,activity);
    }
    public LiveData<SignUpRepoModel> getData(){
        return signUpRepo.getSigUpModel();
    }
}
