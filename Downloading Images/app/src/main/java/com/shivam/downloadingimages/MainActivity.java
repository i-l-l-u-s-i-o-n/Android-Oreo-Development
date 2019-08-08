package com.shivam.downloadingimages;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {


    ImageView image;

    public void downloadImage(View view){

        ImageDownloader downloader = new ImageDownloader();

        try {

            Bitmap downloadedImage=downloader.execute("https://www.crockerriverside.org/sites/main/files/main-images/camera_lense_0.jpeg").get();

            image.setImageBitmap(downloadedImage);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        image= findViewById(R.id.image);

    }


    public class ImageDownloader extends AsyncTask<String, Void, Bitmap>{




        @Override
        protected Bitmap doInBackground(String... urls) {

            URL url;
            HttpsURLConnection connection;

            try {
                url=new URL(urls[0]);
                connection = (HttpsURLConnection) url.openConnection();

                connection.connect();

                // Get inputStream
                InputStream in = connection.getInputStream();

                // Now convert it into image
                Bitmap image1 = BitmapFactory.decodeStream(in);

                return image1;

            }catch (Exception e){
                e.printStackTrace();

                return null;
            }

        }
    }
}
