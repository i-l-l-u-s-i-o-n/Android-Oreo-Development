package com.example.numbertableusinglistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.seekBar);

        final ListView listView = findViewById(R.id.lv);

        final List<Integer> table = new ArrayList<>();

        final int min =1;
        int max=25;
        seekBar.setMax(max);
        seekBar.setProgress(min);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                table.clear();

                if (progress<min){
                    seekBar.setProgress(min);
                }
                for (int i=1;i<=20;i++){
                    table.add(progress*i);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                ArrayAdapter<Integer> arrayAdapter =new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,table);
                listView.setAdapter(arrayAdapter);

            }
        });

    }
}
