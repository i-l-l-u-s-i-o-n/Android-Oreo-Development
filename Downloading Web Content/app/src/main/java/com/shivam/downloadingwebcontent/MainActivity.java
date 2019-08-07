package com.shivam.downloadingwebcontent;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {


    // We have do the downloading task in a background thread so we have to inherit AsyncTask Class.
    public class DownloadBackgroundTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) {

            Log.i("Status",urls[0]);

            URL url;   // This object is used to convert the String into URL

            // This can be thought as of browser which fetches the HTML (But it won't render it)
            HttpsURLConnection httpsURLConnection;

            String content= "";

            try {
                url = new URL(urls[0]);


                // We also have to ask user for permission of using internet.So in manifest file,we have to add the permission of internet.
                httpsURLConnection= (HttpsURLConnection) url.openConnection();


                InputStream in = httpsURLConnection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1){

                    char charater = (char) data;
                    content += charater;
                    data = reader.read();

                }

                return content;
            }catch (Exception e){
                e.printStackTrace();
                return "Something went wrong!";
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DownloadBackgroundTask task=new DownloadBackgroundTask();

        try{
            Log.i("Status",task.execute("https://camphub.herokuapp.com/").get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
