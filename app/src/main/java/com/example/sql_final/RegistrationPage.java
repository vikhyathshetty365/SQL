package com.example.sql_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity {
    EditText userName,passWord;
    DBHelper dbHelper;
    public static final String DBNAME = "userdb";
    public static final String TBNAME = "users";
    public static final int DBVERSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        userName = (EditText) findViewById(R.id.username);
        passWord = (EditText) findViewById(R.id.psw);
    }
    public void goToLogin(View view) {
        dbHelper = new DBHelper(RegistrationPage.this,DBNAME,null,DBVERSION);
        long res = dbHelper.addUser(userName.getText().toString(),passWord.getText().toString());
        if (res==-1){
            Toast.makeText(this, "Registration Unsuccessful", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_LONG).show();
            Intent i = new Intent(RegistrationPage.this, check_user.class);
            startActivity(i);
        }
    }
}