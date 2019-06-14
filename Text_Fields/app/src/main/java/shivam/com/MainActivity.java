package shivam.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public void click(View view){

        EditText name=(EditText) findViewById(R.id.name);
        EditText pass=(EditText) findViewById(R.id.password);

        Log.i("info","Login Successful !");
        Log.i("info","Username : "+name.getText());
        Log.i("info","Password : "+pass.getText());

        // To display text on Screen

        Toast.makeText(this, "Logged In !"+name.getText(), Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
