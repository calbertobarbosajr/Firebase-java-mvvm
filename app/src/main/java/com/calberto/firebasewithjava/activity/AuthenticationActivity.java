package com.calberto.firebasewithjava.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProvider;

import com.calberto.firebasewithjava.databinding.ActivityAuthenticationBinding;
import com.calberto.firebasewithjava.viewModel.AuthenticationViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;

public class AuthenticationActivity extends AppCompatActivity {

    private ActivityAuthenticationBinding binding;
    private AuthenticationViewModel authenticationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAuthenticationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        this.authenticationViewModel = new ViewModelProvider(this).get(AuthenticationViewModel.class);

        // Inicializa observers
        this.createObservers();
    }

    private void createObservers() {
        this.authenticationViewModel.toastNotification().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }





    public void signin(View view) {
        String email = this.binding.editEmailLogin.getText().toString().trim();
        String password = this.binding.editEmailPassword.getText().toString().trim();
        this.authenticationViewModel.doLogin(email, password);
        this.authenticationViewModel.logado(AuthenticationActivity.this);
    }

    public void recoverPassword(View view) {
    }

    public void signup(View view) {
        startActivity( new Intent(this, RegisterActivity.class));
    }
}