package com.example.sql_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class deleteActivity extends AppCompatActivity {
    EditText userName;
    DBHelper dbHelper;

    public static final String DBNAME = "userdb";
    public static final String TBNAME = "users";
    public static final int DBVERSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        userName = (EditText) findViewById(R.id.username);

    }

    public void DeleteUser(View view) {
        dbHelper = new DBHelper(deleteActivity.this, DBNAME, null, DBVERSION);
        dbHelper.deleteUser(userName.getText().toString());
        Toast.makeText(this, "Deletion Successful", Toast.LENGTH_LONG).show();
        Intent i = new Intent(deleteActivity.this, Loginorregister.class);
        startActivity(i);
    }
}