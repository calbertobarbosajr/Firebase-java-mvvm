package com.calberto.firebasewithjava.helper;


import static androidx.core.content.ContextCompat.startActivity;
import static java.security.AccessController.getContext;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.calberto.firebasewithjava.activity.MainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class OpenScreen extends Activity {

    private static FirebaseAuth auth = FirebaseAuth.getInstance();
    private static Activity activity;

    public void openMainScreen(){

        Intent intent = new Intent(activity, MainActivity.class);
        startActivity(intent);
    }








}
