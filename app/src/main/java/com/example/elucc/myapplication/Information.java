package com.example.elucc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Information extends AppCompatActivity {

    private Button BtnMove12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        BtnMove12 = findViewById(R.id.button12);

        BtnMove12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToActivityTwelve();
            }
        });
    }

    private void moveToActivityTwelve() {
        Intent intent = new Intent(Information.this, Main2Activity.class);
        startActivity(intent);
    }
}
