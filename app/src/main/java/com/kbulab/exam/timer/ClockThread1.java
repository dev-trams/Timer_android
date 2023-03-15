package com.kbulab.exam.timer;

import android.content.Context;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockThread1 extends Thread{
    Context context;

    TextView textView;
    Handler handler;

    public ClockThread1(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        while (true) {
            Calendar calendar = Calendar.getInstance();
            String time = dateFormat.format(calendar.getTime());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Toast.makeText(context.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
