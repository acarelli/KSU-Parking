package com.example.elucc.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Count2 extends AppCompatActivity {

    private TextView mTextViewResult2;
    private Button BtnMove5;
    private ImageButton BtnMove7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count2);

        BtnMove7 = findViewById(R.id.imageButton);

        BtnMove7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToActivitySeven();
            }
        });

        BtnMove5 = findViewById(R.id.button7);

        BtnMove5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToActivityFive();
            }
        });

        mTextViewResult2 = findViewById(R.id.textView14);

        OkHttpClient client = new OkHttpClient();

        String url = "https://streetsoncloud.com/parking/rest/occupancy/id/112";

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    char ch = Character.MIN_VALUE;
                    String[] fields;
                    String[] free = new String[0];
                    int count = 0;
                    fields = myResponse.split(",");
                    if (fields[0].contains("OK")) {
                        free = fields[6].split(":");
                        free[1] = free[1].replace('"', ch);

                    }
                    //count = Integer.parseInt(free[1]); //Stops application here
                    final int finalCount = count;
                    final String[] finalFree = free;
                    Count2.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewResult2.setText(finalFree[1] + "/155"); // End of application here.
                        }
                    });

                }
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
                Intent intent = new Intent(Count2.this, Settings.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void moveToActivityFive() {
        Intent intent = new Intent(Count2.this, Occupancy.class);
        startActivity(intent);
    }

    public void browser2(View view) {
        Intent browserIntent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/dir/Current+Location/S-38 Lot, Kent, OH 44243"));
        startActivity(browserIntent);

    }

    private void moveToActivitySeven() {
        Intent intent = new Intent(Count2.this, Count2.class);
        startActivity(intent);
    }
}
