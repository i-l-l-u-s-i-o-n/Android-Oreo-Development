package shivam.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void play(View v){

        VideoView videoView=findViewById(R.id.video);

        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.game);

        // To control the video i,e, to pause or to seek forward etc, we have to add Media controller to it.
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}
