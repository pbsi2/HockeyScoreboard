package com.pbsi2.hockeyscoreboard;


import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Switch startStop;
    private RadioGroup periodButtons;
    private Chronometer periodChronometer;
    /*
        I used progress bars for future enhancements, the preriods indicators will progressively get green as times goes
    */

    private ProgressBar progressBar;
    private ProgressBar progressBar2;
    private ProgressBar progressBar3;
    private boolean isStart = false;
    /*
        Need the periods to start at false, that allows the timeStart/setBase() to be set to 20 mins
        when it is not the start of a period the Chronometer will be reset to the time at which it was stopped
    */
    private boolean isFirstPeriod = false;
    private boolean isSecondPeriod = false;
    private boolean isThirdPeriod = false;
    private int homeScore = 0;
    private int visitorScore = 0;
    // milli, sec, min calculations, Hockey periods last 20 Mins
    private long timeStart = (1000 * 20);
    private long timeAtStop = 0;
    // which period are we in?
    private int period = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        periodButtons = findViewById(R.id.radiogroup_view);
        startStop = findViewById(R.id.start_stop_time_switch);
        periodChronometer = findViewById(R.id.time_toplay_textview);
        periodChronometer.setText("20:00");
        periodChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometerChanged) {
                periodChronometer = chronometerChanged;
                long pBase = periodChronometer.getBase();
                long pElapsed = SystemClock.elapsedRealtime();
                if ((pBase - pElapsed) <= 0) {
                    Toast.makeText(MainActivity.this, "Period: " + period, Toast.LENGTH_LONG).show();

                    toggleChrono(periodChronometer);
                    period += 1;
                    startStop.toggle();
                    timeStart = (1000 * 20);
                }
            }
        });


    }

    public void toggleChrono(View view) {
/* TODO add code and xml for overtime period

        If the clock is running the switch can only go to stop
        We need to get the time elapsed so the restart time will be set to the time when switch was set to stop
*/
        if (period == 2) {
            RadioButton radioButton2 = findViewById(R.id.second_period_radioButton);
            litSecondPeriod(radioButton2);
        }
        if (period == 3) {
            RadioButton radioButton3 = findViewById(R.id.third_period_radioButton);
            litThirdPeriod(radioButton3);
        }
        if (isFirstPeriod || isSecondPeriod || isThirdPeriod) {
            if (isStart) {
                long pBase = periodChronometer.getBase();
                long pElapsed = SystemClock.elapsedRealtime();
                timeAtStop = pBase - pElapsed;
                periodChronometer.stop();
                isStart = false;

            } else {
/*
            We will start or restart the clock countdown.
             That time depends on where we are in the game
             1- Start of period: timeStart is 20 Mins
             2- Restart within a period: timeStart is not needed, we use time timeAtStop set when we switched the chrono to stop.
             TIME with the Chronometer widget is tricky, the Chrono starts at app start and stops at app stop, so we have to work with elapsed times.
*/
                periodChronometer.setBase(SystemClock.elapsedRealtime() + timeAtStop + timeStart);
                Toast.makeText(MainActivity.this, "timeStart: " + (timeStart % 60), Toast.LENGTH_LONG).show();

                periodChronometer.start();
                isStart = true;
                timeStart = 0;
            }
        } else {

/*
            Got to be set for a period to start, therefore has to select the right period. If not then we toggle the switch back to stop.
*/
            Toast.makeText(MainActivity.this, "PLEASE SELECT A PERIOD !!!", Toast.LENGTH_LONG).show();
            startStop.toggle();
        }
    }

    private void displayHomeScore(int number) {
        TextView homeScoreTextView = findViewById(R.id.team1_score);
        homeScoreTextView.setText("" + number);
    }

    public void homeScored(View view) {
        if (isStart) {
            Toast.makeText(MainActivity.this, "Can't add score while the clock is running!!!", Toast.LENGTH_LONG).show();
        } else {
            homeScore += 1;
            displayHomeScore(homeScore);
        }

    }

    public void substracthomeScored(View view) {
        if (isStart) {
            Toast.makeText(MainActivity.this, "Can't substract score while the clock is running!!!", Toast.LENGTH_LONG).show();
        } else {
            if (homeScore > 0) {
                homeScore -= 1;
                displayHomeScore(homeScore);
            }
        }
    }

    private void displayVisitorScore(int number) {
        TextView homeScoreTextView = findViewById(R.id.team2_score);
        homeScoreTextView.setText("" + number);
    }

    public void visitorScored(View view) {
        if (isStart) {
            Toast.makeText(MainActivity.this, "Can't add score while the clock is running!!!", Toast.LENGTH_LONG).show();
        } else {
            visitorScore += 1;
            displayVisitorScore(visitorScore);
        }
    }

    public void substractVisitorScored(View view) {
        if (isStart) {
            Toast.makeText(MainActivity.this, "Can't substract score while the clock is running!!!", Toast.LENGTH_LONG).show();
        }
        if (visitorScore > 0) {
            visitorScore -= 1;
            displayVisitorScore(visitorScore);
        }
    }

    public void litFirstPeriod(View v) {
        if (period == 0) {
            isFirstPeriod = true;
            period = 1;
            progressBar = findViewById(R.id.progressBar);
            progressBar.setProgress(40);
            periodButtons.clearCheck();
        } else {
            Toast.makeText(MainActivity.this, "Can't be triggered, Game is ongoing !!!", Toast.LENGTH_LONG).show();
            periodButtons.clearCheck();
        }
    }

    public void litSecondPeriod(View v) {
        if (isFirstPeriod && (period == 2)) {
            isSecondPeriod = true;
            progressBar = findViewById(R.id.progressBar);
            progressBar.setProgress(40);
            progressBar2 = findViewById(R.id.progressBar2);
            progressBar2.setProgress(40);
            periodButtons.clearCheck();
        } else {
            Toast.makeText(MainActivity.this, "Can't be triggered, First Period is ongoing !!!", Toast.LENGTH_LONG).show();
            periodButtons.clearCheck();
        }
    }

    public void litThirdPeriod(View v) {

        if (isSecondPeriod && (period == 3)) {
            isThirdPeriod = true;
            progressBar = findViewById(R.id.progressBar);
            progressBar.setProgress(40);
            progressBar2 = findViewById(R.id.progressBar2);
            progressBar2.setProgress(40);
            progressBar3 = findViewById(R.id.progressBar3);
            progressBar3.setProgress(40);
            periodButtons.clearCheck();
        } else {
            Toast.makeText(MainActivity.this, "Can't be triggered, Second Period is ongoing !!!", Toast.LENGTH_LONG).show();
            periodButtons.clearCheck();
        }
    }

    public void resetAll(View view) {
        isStart = false;
        isFirstPeriod = false;
        isSecondPeriod = false;
        isThirdPeriod = false;
        homeScore = 0;
        visitorScore = 0;
        timeStart = (1000 * 20);
        timeAtStop = 0;
        period = 0;
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar2.setProgress(0);
        progressBar3 = findViewById(R.id.progressBar3);
        progressBar3.setProgress(0);
        displayHomeScore(homeScore);
        displayVisitorScore(visitorScore);
        periodChronometer.stop();
        periodChronometer.setText("20:00");
    }
}




