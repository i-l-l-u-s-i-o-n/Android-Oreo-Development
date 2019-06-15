package shivam.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void check(View v){

        EditText numberText=findViewById(R.id.number);

        int number=Integer.valueOf(numberText.getText().toString());

        if (number>19){
            Toast.makeText(this,"Too High !",Toast.LENGTH_SHORT).show();
        }else if(number<19){
            Toast.makeText(this,"Too Low !",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"You got it right !",Toast.LENGTH_SHORT).show();
        }
    }
}
