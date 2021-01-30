package com.example.sql_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayPage extends AppCompatActivity {
    TextView contents;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_page);
        contents = (TextView) findViewById(R.id.content);
        dbHelper = new DBHelper(DisplayPage.this,DBHelper.DBNAME,null,DBHelper.DBVERSION);
        String data = dbHelper.displayUsers();
        contents.setText(data);
    }
    public void GoHome(View view){
        Intent it = new Intent(DisplayPage.this, Loginorregister.class);
        startActivity(it);
    }
}