package com.example.sql_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class check_user extends AppCompatActivity {
    EditText userName,passWord;
    DBHelper dbHelper;

    public static final String DBNAME = "userdb";
    public static final String TBNAME = "users";
    public static final int DBVERSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_user);
        userName = (EditText) findViewById(R.id.username);
        passWord = (EditText) findViewById(R.id.psw);
    }

    public void goToFeatures(View view) {
        dbHelper = new DBHelper(check_user.this,DBNAME,null,DBVERSION);
        int res = dbHelper.checkUser(userName.getText().toString(),passWord.getText().toString());
        if (res==1){
            Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
            Intent i = new Intent(check_user.this,All_features.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Login Unsuccessful", Toast.LENGTH_LONG).show();
            Intent i = new Intent(check_user.this,Loginorregister.class);
            startActivity(i);
        }
    }
}