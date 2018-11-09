package com.pbsi2.hockeyscoreboard;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {


    private Chronometer periodChronometer;
    private ProgressBar progressBar;
    private ProgressBar progressBar2;
    private ProgressBar progressBar3;
    private boolean isStart = false;

    private boolean isFirstPeriod;
    private boolean isSecondPeriod;
    private boolean isThirdPeriod;
    private int homeScore = 0;
    private int visitorScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        periodChronometer = findViewById(R.id.time_toplay_textview);
//        periodChronometer.setBase(60 * 2 * 1000 * -1);
//        periodChronometer.setFormat("MM:SS");
        periodChronometer.setCountDown(true);

        periodChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometerChanged) {
                periodChronometer = chronometerChanged;
            }
        });


    }

    public void toggleChrono(View view) {

        //periodChronometer.setCountDown(true);
        if (isStart) {
            periodChronometer.stop();
            isStart = false;

        } else {
            periodChronometer.setBase(((long) 60 * 2 * 1000));
//            - SystemClock.elapsedRealtime()
            periodChronometer.start();
            isStart = true;

        }
    }

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
        if (isFirstPeriod) {
            isSecondPeriod = true;
            progressBar = findViewById(R.id.progressBar);
            progressBar.setProgress(40);
            progressBar2 = findViewById(R.id.progressBar2);
            progressBar2.setProgress(40);
        }
    }

    public void litThirdPeriod(View v) {

        if (isSecondPeriod) {
            isThirdPeriod = true;
            progressBar = findViewById(R.id.progressBar);
            progressBar.setProgress(40);
            progressBar2 = findViewById(R.id.progressBar2);
            progressBar2.setProgress(40);
            progressBar3 = findViewById(R.id.progressBar3);
            progressBar3.setProgress(40);
        }
    }
}




