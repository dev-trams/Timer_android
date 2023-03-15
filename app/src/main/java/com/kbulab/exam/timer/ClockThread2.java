package com.kbulab.exam.timer;

import android.content.Context;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockThread2 extends Thread{
    Context context;
    TextView textView;
    Handler handler;

    public ClockThread2(Context context, TextView textView) {
        this.context = context;
        this.textView = textView;
    }

    @Override
    public void run() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        handler = new Handler();

        while (true) {
            Calendar calendar = Calendar.getInstance();
            String time = dateFormat.format(calendar.getTime());
            handler.post(new Runnable() {
                @Override
                //Main Thread 에서 실행될 런
                public void run() {
                    textView.setText(time);
                }
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }
}
