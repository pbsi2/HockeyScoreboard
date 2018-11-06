package com.pbsi2.hockeyscoreboard;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    long displayTime;
    String currentTimeLeft = "20:00";
    long lcurrentTimeLeft;
    private Chronometer periodChronometer;
    private TextView display;
    private ProgressBar progressBar;
    private boolean isStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //display = findViewById(R.id.t1_pen4_textview);
        //progressBar = findViewById(R.id.progressBar);
        //periodChronometer = findViewById(R.id.time_left_textview);

        //periodChronometer.setBase(60 * 2 * 1000);
        //periodChronometer.setFormat("MM:SS");
        //periodChronometer.setCountDown(true);


/*        periodChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometerChanged) {
                periodChronometer.setBase(60 * 2 * 1000);
                Toast.makeText(MainActivity.this, "Started 1:" + currentTimeLeft, Toast.LENGTH_SHORT).show();
                display.setText("HH" + currentTimeLeft);
                String[] data = currentTimeLeft.split(":");
                //int minutes = Integer.getInteger(data[0]);
                //int seconds = Integer.getInteger(data[1]);
                currentTimeLeft = periodChronometer.getText().toString();
                Toast.makeText(MainActivity.this, "Started:" + currentTimeLeft, Toast.LENGTH_SHORT).show();
                display.setText(currentTimeLeft);
                if (currentTimeLeft.contentEquals("01:13")) {
                    Toast.makeText(MainActivity.this, "time reached", Toast.LENGTH_SHORT).show();
                    chronometerChanged.stop();

                }
                if (currentTimeLeft.contains(":00") || currentTimeLeft.contains(":30")) {
                    Toast.makeText(MainActivity.this, "Second reached", Toast.LENGTH_SHORT).show();
                    displayTime += 1;
                    progressBar.setProgress((int) displayTime);
                }
                periodChronometer = chronometerChanged;
            }

        }); */

    }

    /*public void startStopChrono(View v) {

        //periodChronometer.setCountDown(true);
        if (isStart) {
            periodChronometer.stop();
            isStart = false;
            ((Button) v).setText("Start");
        } else {
            //periodChronometer.setBase((long) 60 * 2 * 1000);
            periodChronometer.start();
            isStart = true;
            ((Button) v).setText("Stop");
        }
    }*/


}




