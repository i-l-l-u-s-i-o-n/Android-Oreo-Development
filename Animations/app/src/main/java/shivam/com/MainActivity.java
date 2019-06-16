package shivam.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // As we have to enter the bart image by rotation when the application loads, so we have to put the code here.
        ImageView bart=findViewById(R.id.enterBartOnLoad);

        // Initially bart is hidden or at the very left of the screen.
        bart.setX(-1000);

        // Now we animate the image.
        bart.animate().translationXBy(1000).rotation(1800).setDuration(2000);
    }


    int cc=0;
    public void fade(View view){

        ImageView bart=findViewById(R.id.bart);
        ImageView homer=findViewById(R.id.homer);
        if (cc==0) {
            cc=1;
            bart.animate().alpha(0).setDuration(2000);
            homer.animate().alpha(1).setDuration(2000);
        }else{
            cc=0;
            bart.animate().alpha(1).setDuration(2000);
            homer.animate().alpha(0).setDuration(2000);
        }
    }


    boolean bartRotated=false;
    public void rotateAndScaleUpBart(View v){

        ImageView bart=findViewById(R.id.rotateBart);

        if (!bartRotated){
            bartRotated=true;

            // We can use various animation together.
            // We can fade a image after rotating as ->
            // bart.animate().rotation(1800).alpha(0).setDuration(2000);

            // Here we are rotating and shrinking the image to half of the size.
            bart.animate().rotation(1800).scaleX(0.5f).scaleY(0.5f).setDuration(3000);
        }else{
            bartRotated=false;
            bart.animate().rotation(-1800).scaleX(1.0f).scaleY(1.0f).setDuration(3000);

        }
    }

    public void rotateAndScaleXBy(View v){



    }
}
