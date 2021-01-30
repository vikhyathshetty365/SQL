package com.example.sql_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Loginorregister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginorregister);
    }

    public void goToLogin(View view) {
        Intent i = new Intent(Loginorregister.this, check_user.class);
        startActivity(i);
    }

    public void goToRegister(View view) {
        Intent i = new Intent(Loginorregister.this, RegistrationPage.class);
        startActivity(i);
    }
}