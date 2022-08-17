package com.calberto.firebasewithjava.viewModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.calberto.firebasewithjava.activity.MainActivity;
import com.calberto.firebasewithjava.model.User;
import com.calberto.firebasewithjava.repository.AuthenticationRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthenticationViewModel extends ViewModel {

    private AuthenticationRepository authenticationRepository = new AuthenticationRepository();

    private MutableLiveData<String> textEmail = new MutableLiveData<>();
    private MutableLiveData<String> textPassword = new MutableLiveData<>();
    private MutableLiveData<String> mToastNotification = new MutableLiveData<>();
    private MutableLiveData<String> logado = new MutableLiveData<>();

    private static Context context;

    private FirebaseAuth auth = FirebaseAuth.getInstance();

    // Observáveis
    // Observáveis
    public LiveData<String> toastNotification() {
        return mToastNotification;
    }

    public LiveData<String> login() {
        return logado;
    }


    public void doLogin(String email, String password) {

        User user = new User();
        user.setEmail( email );
        user.setPassword( password );

        this.authenticationRepository.ConfirmLoginEmail( user );
    }

    public void logado (final Activity activity){
        if ( this.authenticationRepository.Success ){
            this.mToastNotification.setValue("Success");
            Intent intent = new Intent( activity, MainActivity.class);
            activity.startActivity(intent);
        } else{
            this.mToastNotification.setValue("Falha");
        }
    }






}
