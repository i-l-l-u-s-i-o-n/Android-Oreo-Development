package com.example.timerapp;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView ;
    SeekBar seekBar;
    Button goButton;
    Boolean isCounterActive;
    CountDownTimer timer;


    public void resetTimer(){
        seekBar.setProgress(10);
        textView.setText("00:10");
        seekBar.setEnabled(true);
        timer.cancel();
        goButton.setText("Go !");
        isCounterActive=false;
    }

    public void startTimer(View view){

        if (isCounterActive){
            resetTimer();

        }else {

            isCounterActive=true;
            seekBar.setEnabled(false);
            goButton.setText("Stop !");
            timer= new CountDownTimer(seekBar.getProgress() * 1000 + 100, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    //Log.i("Status", Integer.toString(seekBar.getProgress() * 1000-(int)millisUntilFinished));
                    updateTime((int) millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {
                    MediaPlayer player = MediaPlayer.create(getApplicationContext(), R.raw.air);
                    player.start();
                    resetTimer();
                }
            }.start();
        }
    }


    void updateTime(int progress){
        int minutes= progress/60;
        int seconds= progress%60;
        String minuteString=Integer.toString(minutes) ,
                secondString =Integer.toString(seconds);

        if (minuteString.length()==1){
            minuteString= '0'+ minuteString;
        }
        if (secondString.length()==1){
            secondString= '0'+ secondString;
        }


        textView.setText(minuteString+":"+secondString);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar= findViewById(R.id.seekBar);
        textView=findViewById(R.id.textView);
        goButton=findViewById(R.id.button);
        seekBar.setMax(600);
        seekBar.setProgress(10);
        textView.setText("00:10");

        isCounterActive=false;

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                updateTime(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
