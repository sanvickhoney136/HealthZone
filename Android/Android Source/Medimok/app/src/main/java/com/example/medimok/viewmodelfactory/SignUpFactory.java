package com.example.medimok.viewmodelfactory;

import android.app.Activity;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.medimok.models.localmodel.SigUpModel;
import com.example.medimok.viewmodels.SignUpViewModel;

public class SignUpFactory extends ViewModelProvider.NewInstanceFactory {
    @NonNull
    private final Application application;

    SigUpModel sigUpModel;
    Activity activity;

    public SignUpFactory(@NonNull Application application, SigUpModel sigUpModel,Activity activity) {
        this.application = application;
        this.sigUpModel = sigUpModel;
        this.activity=activity;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == SignUpViewModel.class) {
            return (T) new SignUpViewModel(application, sigUpModel,activity);
        }
        return null;
    }
}
