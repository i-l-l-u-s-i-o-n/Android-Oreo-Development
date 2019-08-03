package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=findViewById(R.id.lv);

        final List<String> teamMembers = new ArrayList<>();

        teamMembers.add("Shivam");
        teamMembers.add("Tim");
        teamMembers.add("Colt");
        teamMembers.add("John");
        teamMembers.add("Henry");

        // ArrayAdapter is used to populate the list busing elements of arrays!
        final ArrayAdapter<String> arrayAdapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, teamMembers);

        // Now attach this adapter to listView.
        listView.setAdapter(arrayAdapter);


        // To set what happens when we click the list item.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Here in the toast, we have to pass the context of onCreate method, not the onItemClick, so we pass super.getBaseContext() to Toast instead of this.
                //Toast.makeText(MainActivity.super.getBaseContext(),teamMembers.get(position),Toast.LENGTH_LONG).show();
                // We can also do following
                Toast.makeText(getApplicationContext(),teamMembers.get(position),Toast.LENGTH_LONG).show();

                Log.i("Name clicked : ", teamMembers.get(position));

            }
        });





    }
}
