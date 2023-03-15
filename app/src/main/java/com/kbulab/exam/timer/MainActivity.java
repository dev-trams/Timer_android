package com.kbulab.exam.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);
        int count = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        while (count < 10) {
            Calendar calendar = Calendar.getInstance();
            String time = dateFormat.format(calendar.getTime());
            textView.setText(time);
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}