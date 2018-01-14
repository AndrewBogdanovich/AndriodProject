package com.andrewbogdanovich.github.andriodproject;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ArticleParseTask extends AsyncTask<Void, Void, String> {

    private static final String LOG_TAG = "JSONString";
    private String resultJson = " ";


    @Override
    protected String doInBackground(Void... params) {
        try {
            URL url = new URL("https://newsapi.org/v2/everything?sources=bbc-news&apiKey=5bc6e75ca8504c018d8f51e5b6f48789");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder buffer = new StringBuilder();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            resultJson = buffer.toString();

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return resultJson;
    }


    @Override
    protected void onPostExecute(String strJson) {
        super.onPostExecute(strJson);
        Log.i(LOG_TAG, strJson);
    }

}
