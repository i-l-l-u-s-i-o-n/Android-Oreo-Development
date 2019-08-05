package com.shivam.guessin30seconds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    String equationString ;
    int result ;
    int indexOfCorrectAnswer ;
    ArrayList<Integer> options =new ArrayList<>();


    public void start(View view){
        startButton.setVisibility(View.INVISIBLE);
    }


    public void optionPressed(View view){

        int tag = (Integer)view.getTag();
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button op1= findViewById(R.id.option1);
        Button op2= findViewById(R.id.option2);
        Button op3= findViewById(R.id.option3);
        Button op4= findViewById(R.id.option4);

        TextView equation = findViewById(R.id.equation);

        Random random =new Random();

        int equationType=random.nextInt(2);  // Generates Random number 0,1



        if (equationType == 0 ) {
//            a+b*c
            int a=random.nextInt(20)+1;
            int b=random.nextInt(10)+1;
            int c=random.nextInt(10)+1;

            result = a+b*c;
            equationString= a +" + "+ b+ " * "+ c + " = ?";
        }else{
//            a%b-c
            int a=random.nextInt(20)+1;
            int b=random.nextInt(10)+1;
            int c=random.nextInt(10)+1;

            result=a%b-c;
            equationString= a +" % "+ b+ " - "+ c+ " = ?";
        }

        // Set equation to the TextView
        equation.setText(equationString);

        // Now generate the 4 options and add it to List

        indexOfCorrectAnswer=random.nextInt(4);  // Location of correct ans in List.

        for (int i=0; i<4; i++){

            if (i == indexOfCorrectAnswer)
                options.add(result);

            else{

                int wrongAnsLogic=random.nextInt(2);
                int wrongAnswer;
                if (wrongAnsLogic==0){
                    wrongAnswer =random.nextInt(8)+result;
                    while(wrongAnswer == result || options.contains(wrongAnswer)){
                        wrongAnswer=random.nextInt(8)+result;
                    }
                }else{
                    wrongAnswer =random.nextInt(8)+result;
                    while(wrongAnswer == result || options.contains(wrongAnswer)){
                        wrongAnswer=random.nextInt(8)-result;
                    }
                }

                options.add(wrongAnswer);
            }

        }


        op1.setText(Integer.toString(options.get(0)));
        op2.setText(Integer.toString(options.get(1)));
        op3.setText(Integer.toString(options.get(2)));
        op4.setText(Integer.toString(options.get(3)));


        startButton=findViewById(R.id.startButton);

    }
}
