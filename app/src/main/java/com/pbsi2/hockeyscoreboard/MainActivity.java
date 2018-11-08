package com.pbsi2.hockeyscoreboard;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
    private ProgressBar progressBar2;
    private ProgressBar progressBar3;
    private boolean isStart;
    private boolean isFirstPeriod;
    private boolean isSecondPeriod;
    private boolean isThirdPeriod;
    private int homeScore = 0;
    private int visitorScore = 0;

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

    private void displayHomeScore(int number) {
        TextView homeScoreTextView = findViewById(R.id.team1_score);
        homeScoreTextView.setText("" + number);
    }

    public void homeScored(View view) {

        homeScore += 1;
        displayHomeScore(homeScore);
    }

    public void substracthomeScored(View view) {
        int number = 1;
        if (homeScore > 0)
            homeScore -= number;
        displayHomeScore(homeScore);
    }

    private void displayVisitorScore(int number) {
        TextView homeScoreTextView = findViewById(R.id.team2_score);
        homeScoreTextView.setText("" + number);
    }

    public void visitorScored(View view) {

        visitorScore += 1;
        displayVisitorScore(visitorScore);
    }

    public void substractVisitorScored(View view) {
        int number = 1;
        if (visitorScore > 0)
            visitorScore -= number;
        displayVisitorScore(visitorScore);
    }

    public void litFirstPeriod(View v) {
        isFirstPeriod = true;
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(40);
    }

    public void litSecondPeriod(View v) {
        isFirstPeriod = true;
        isSecondPeriod = true;
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(40);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar2.setProgress(40);
    }

    public void litThirdPeriod(View v) {
        isFirstPeriod = true;
        isSecondPeriod = true;
        isThirdPeriod = true;
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(40);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar2.setProgress(40);
        progressBar3 = findViewById(R.id.progressBar3);
        progressBar3.setProgress(40);
    }
}




