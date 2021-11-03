package com.example.wr;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class RunningActivity extends BaseCustomActivity {
    long pauseOffset;
    boolean running = false;

    Chronometer chronometer;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.running);
        onNavBarSettings(true);

        chronometer = (Chronometer) findViewById(R.id.timer);
        chronometer.setFormat("%s");
        btn = (Button) findViewById(R.id.btn_running);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!running) {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    pauseOffset = 0;
                    btn.setBackgroundResource(R.drawable.btn_stop);
                    chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                    chronometer.start();
                    running = true;
                } else {
                    btn.setBackgroundResource(R.drawable.btn_play);
                    chronometer.stop();
                    pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                    running = false;
                }
            }
        });
    }
}

