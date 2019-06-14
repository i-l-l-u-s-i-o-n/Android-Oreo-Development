package shivam.com;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    int cc=0;
    public void changeImage(View v){

        ImageView image=findViewById(R.id.img);

        if (cc==0){
            cc=1;
            image.setImageResource(R.drawable.image1);
        }
        else{
            cc=0;
            image.setImageResource(R.drawable.image2);
        }
    }
}
