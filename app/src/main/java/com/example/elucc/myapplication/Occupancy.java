package com.example.elucc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Occupancy extends AppCompatActivity {

    private Button BtnMove2;
    private Button BtnMove3;
    private Button BtnMove11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_occupancy);

        BtnMove11 = findViewById(R.id.button4);

        BtnMove11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToActivityEleven();
            }
        });

        BtnMove3 = findViewById(R.id.button3);

        BtnMove3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToActivityThree();
            }
        });

        BtnMove2 = findViewById(R.id.button2);

        BtnMove2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToActivityTwo();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.commonmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId() ) {
            case R.id.mnuSettings:
                Intent intent =new Intent (Occupancy.this, Settings.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void moveToActivityTwo() {
        Intent intent = new Intent(Occupancy.this, Count.class);
        startActivity(intent);
    }

    private void moveToActivityThree() {
        Intent intent = new Intent(Occupancy.this, Count2.class);
        startActivity(intent);
    }

    private void moveToActivityEleven() {
        Intent intent = new Intent(Occupancy.this, Main2Activity.class);
        startActivity(intent);
    }
}
