package com.example.elucc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    private Button BtnMove8;
    private Button BtnMove9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        BtnMove9 = findViewById(R.id.button10);

        BtnMove9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToActivityNine();
            }
        });

        BtnMove8 = findViewById(R.id.button9);

        BtnMove8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToActivityEight();
            }
        });
    }

    private void moveToActivityEight() {
        Intent intent = new Intent(Settings.this, Main2Activity.class);
        startActivity(intent);
    }

    private void moveToActivityNine() {
        Intent intent = new Intent(Settings.this, MainActivity.class);
        startActivity(intent);
    }
}
