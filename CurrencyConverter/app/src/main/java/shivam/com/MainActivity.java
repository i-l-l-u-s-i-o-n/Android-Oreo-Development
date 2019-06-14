package shivam.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convert(View view){


        EditText inDollarText=(EditText)findViewById(R.id.inDollar);
        double inDollar=Double.valueOf(inDollarText.getText().toString());

        double inRupee=inDollar*69.82;

        Log.i("info",""+inRupee);

        Toast.makeText(this,"About "+inRupee+" Rupees !", Toast.LENGTH_LONG).show();

    }
}
