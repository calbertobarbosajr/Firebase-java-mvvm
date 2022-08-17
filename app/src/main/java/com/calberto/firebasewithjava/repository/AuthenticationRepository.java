package com.calberto.firebasewithjava.repository;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import com.calberto.firebasewithjava.activity.AuthenticationActivity;
import com.calberto.firebasewithjava.activity.MainActivity;
import com.calberto.firebasewithjava.helper.OpenScreen;
import com.calberto.firebasewithjava.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

import android.content.Context;

import android.app.Application;

public class AuthenticationRepository extends Activity {

    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private MutableLiveData<FirebaseUser> userLiveData;
    private static Context context;
    public boolean Success;
    public String excecao;

    public void ConfirmLoginEmail( User user ){

        // Read user information to login
        auth.signInWithEmailAndPassword(user.getEmail(), user.getPassword()) .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    Success = true;
                }

                else {

                    String excecao = "";
                    try {
                        throw task.getException();
                    }catch ( FirebaseAuthWeakPasswordException e){
                        excecao = "Digite uma senha mais forte!";
                    }catch ( FirebaseAuthInvalidCredentialsException e){
                        excecao= "Por favor, digite um e-mail válido";
                    }catch ( FirebaseAuthUserCollisionException e){
                        excecao = "Este conta já foi cadastrada";
                    }catch (Exception e){
                        excecao = "Erro ao cadastrar usuário: "  + e.getMessage();
                        e.printStackTrace();
                    }

                    //Toast.makeText(AuthenticationRepository.this, excecao, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }





}


