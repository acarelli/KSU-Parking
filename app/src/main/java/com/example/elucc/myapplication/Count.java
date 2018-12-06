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

public class Count extends AppCompatActivity {

    private TextView mTextViewResult;
    private Button BtnMove4;
    private ImageButton BtnMove6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        BtnMove6 = findViewById(R.id.imageButton2);

        BtnMove6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToActivitySix();
            }
        });

        BtnMove4 = findViewById(R.id.button5);

        BtnMove4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToActivityFour();
            }
        });

        mTextViewResult = findViewById(R.id.textView10);

        OkHttpClient client = new OkHttpClient();

        String url ="https://streetsoncloud.com/parking/rest/occupancy/id/113" ;

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

                    Count.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewResult.setText(finalFree[1] + "/356"); // End of application here.
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
                Intent intent = new Intent(Count.this, Settings.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void moveToActivityFour() {
        Intent intent = new Intent(Count.this, Occupancy.class);
        startActivity(intent);
    }

    public void browser1(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/dir/Current+Location/41.1428361111111, -81.3387972222222"));
        startActivity(browserIntent);

    }

    private void moveToActivitySix() {
        Intent intent = new Intent(Count.this, Count.class);
        startActivity(intent);
    }
}
