package shivam.com;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    // It is used to use the Audio in our app.
    MediaPlayer mediaPlayer;

    // It is used to control the volume.
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // when the app opens, we create a media player.
        mediaPlayer=MediaPlayer.create(this,R.raw.audio);


        // when the app opens, we need to create the audioManager so as to control the audio!
        audioManager=(AudioManager)getSystemService(AUDIO_SERVICE);

        SeekBar volumeControl=findViewById(R.id.volumeSeekBar);

        // Since the max volume changes from device to device.
        // So we have to first find the max volume of the particular device using AudioManager.
        int maxVolume=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        // Now we set the max volume to the seek bar.
        volumeControl.setMax(maxVolume);


        // Getting the current volume of system.
        int currentVolume=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        // Setting the slider to the current volume.
        volumeControl.setProgress(currentVolume);


        // Here we are configuring the seekBar to adjust the volume.
        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                // Setting the audio as per the value of slider
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // Now setting up the audio seek bar or Scrub seek bar.

        final SeekBar scrubSeekBar=findViewById(R.id.scrubSeekBar);

        scrubSeekBar.setMax(mediaPlayer.getDuration());

        scrubSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Timer is used to regularly update the scrubSeekBar as the music plays.
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubSeekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,200);   // It updates the scrubSeekBar every Second.

    }

    public void play(View view){
        mediaPlayer.start();
    }
    public void pause(View view){
        mediaPlayer.pause();
    }



}
