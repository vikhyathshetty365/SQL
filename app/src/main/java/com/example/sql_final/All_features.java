package com.example.sql_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class All_features extends AppCompatActivity {
    Button register, delete, update, display;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_features);

        register = findViewById(R.id.register);
        delete = findViewById(R.id.delete);
        update = findViewById(R.id.update);
        display = findViewById(R.id.display);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(All_features.this, AddUser.class);
                startActivity(intent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(All_features.this, deleteActivity.class);
                startActivity(it);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(All_features.this, UpdatePage.class);
                startActivity(intent);
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(All_features.this, DisplayPage.class);
                startActivity(intent);
            }
        });
    }
}