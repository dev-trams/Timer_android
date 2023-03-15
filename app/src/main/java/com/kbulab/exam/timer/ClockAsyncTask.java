package com.kbulab.exam.timer;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockAsyncTask extends AsyncTask<Void, String, Void> {
    Context context;
    TextView textView;

    public ClockAsyncTaask(Context context, TextView textView) {
        this.context = context;
        this.textView = textView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void doInBackground(Void... params) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        while (true) {
            Calendar calendar = Calendar.getInstance();
            String time = dateFormat.format(calendar.getTime());
            publishProgress(time, "1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                publishProgress(e.getMessage(), 2);
            }
        }
    }

    @Override
    protected void onProgressUpdate(String... values) {
        if(values[1].equals("1")){
            textView.setText(values[0]);
        } else {
            Toast.makeText(context, values[0], Toast.LENGTH_SHORT).show();
        }
        super.onProgressUpdate(values);
    }
}
