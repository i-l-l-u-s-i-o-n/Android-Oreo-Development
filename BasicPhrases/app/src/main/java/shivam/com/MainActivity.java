package shivam.com;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void playPhrase(View v){

        Button pressedButton=(Button)v;

        MediaPlayer mediaPlayer=MediaPlayer.create(this,getResources().getIdentifier(pressedButton.getTag().toString(),"raw",getPackageName()));
        mediaPlayer.start();

    }
}
