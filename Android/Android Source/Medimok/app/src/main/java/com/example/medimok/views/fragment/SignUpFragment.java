package com.example.medimok.views.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.medimok.R;
import com.example.medimok.apiservice.ApiServices;
import com.example.medimok.apiservice.RetrofitService;
import com.example.medimok.databinding.FragmentSignupBinding;
import com.example.medimok.interfaces.SignInSignUpHandler;
import com.example.medimok.models.localmodel.SigUpModel;
import com.example.medimok.models.repomodel.SignUpRepoModel;
import com.example.medimok.utils.CommonUtils;
import com.example.medimok.validation.SignUpValidation;
import com.example.medimok.viewmodelfactory.SignUpFactory;
import com.example.medimok.viewmodels.SignUpViewModel;

public class SignUpFragment extends Fragment {
    private FragmentSignupBinding binding;
    private SignInSignUpHandler handler;
    private CommonUtils commonUtils;
    private String TAG = SignUpFragment.class.getName();
    private SigUpModel sigUpModel;
    private ApiServices apiServices;
    private SignUpValidation signUpValidation;

    public SignUpFragment(SignInSignUpHandler handler) {
        this.handler = handler;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, null, false);
        sigUpModel = new SigUpModel();
        binding.setSignUp(this);
        binding.setSignUpModel(sigUpModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        init();
        super.onViewCreated(view, savedInstanceState);
    }

    void init() {
        onBacker();
        commonUtils = new CommonUtils(getContext());
        apiServices = new RetrofitService().getService().create(ApiServices.class);
//        builder = new AlertDialog.Builder(getActivity(), R.style.CustomDialog);
//        inflater = getLayoutInflater();
//        builder.setView(inflater.inflate(R.layout.layout_progressloader, null));
//        alertDialog = builder.create();
//        alertDialog.setCancelable(false);
        signUpValidation = new SignUpValidation(getContext());
    }

    private void onBacker() {
        binding.toolbar.imgBack.setOnClickListener(v ->
                handler.backer("signUp")
        );
    }

    public void onSubmit(SigUpModel sigUpModel) {
        getActivity().getViewModelStore().clear();
        if (signUpValidation.getModel(sigUpModel)) {
            SignUpViewModel signUpViewModel = new ViewModelProvider(requireActivity(),
                    new SignUpFactory(getActivity().getApplication(), sigUpModel, getActivity())).
                    get(SignUpViewModel.class);
            signUpViewModel.getData().observe(getViewLifecycleOwner(), new Observer<SignUpRepoModel>() {
                @Override
                public void onChanged(SignUpRepoModel repoModel) {
                    if (repoModel.getStatus()) {
                        commonUtils.toast(getContext(), "Registration Success...!");
                        new Handler().postDelayed(() -> {
                            handler.newRegister("signIn");
                        },1000);
                    } else {
                        commonUtils.toaster(repoModel.getMessage());
                    }
                }
            });
        }
    }
}
