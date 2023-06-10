package org.geekster;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current_weather=true&hourly=temperature_2m,relativehumidity_2m,windspeed_10m";
        URL Apiurl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) Apiurl.openConnection();
        int responseCode = connection.getResponseCode();
        if(responseCode == 200){
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder apiData = new StringBuilder();
            String readLine  = null;
            while((readLine = in.readLine()) != null){
                apiData.append(readLine);

            }
            in.close();
            JSONObject ans = new JSONObject(apiData.toString());
            System.out.println(ans);
        }
        else{
            System.out.println("API Could not be made");
        }




    }
}