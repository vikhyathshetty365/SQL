package com.example.sql_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdatePage extends AppCompatActivity {

    EditText userName, passWord;
    DBHelper dbHelper;

    public static final String DBNAME = "userdb";
    public static final String TBNAME = "users";
    public static final int DBVERSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_page);
        userName = (EditText) findViewById(R.id.username);
        passWord = (EditText) findViewById(R.id.psw);

    }

    public void userUpdate(View view) {
        dbHelper = new DBHelper(UpdatePage.this, DBNAME, null, DBVERSION);
        dbHelper.updateUser(userName.getText().toString(), passWord.getText().toString());
        Toast.makeText(this, "Updation Successful", Toast.LENGTH_LONG).show();
        Intent i = new Intent(UpdatePage.this, check_user.class);
        startActivity(i);
    }
}