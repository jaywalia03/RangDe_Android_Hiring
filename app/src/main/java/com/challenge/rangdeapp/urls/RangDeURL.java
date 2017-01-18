package com.challenge.rangdeapp.urls;

import android.os.RemoteException;
import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class RangDeURL {
    String urlString;

    public String connectToRangDeServer(){
        StringBuilder strbuilder=new StringBuilder();

        try {
            URL url=new URL(urlString);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream is= httpURLConnection.getInputStream();


            BufferedReader buff = new BufferedReader(new InputStreamReader(is));

            String strbuff;
            while ((strbuff = buff.readLine()) != null) {
                strbuilder.append(strbuff);
                strbuilder.append("\n");
            }
            String jsonstring = strbuilder.toString();

            is.close();


            return jsonstring;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
