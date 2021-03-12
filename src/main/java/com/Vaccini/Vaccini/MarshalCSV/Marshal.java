package com.Vaccini.Vaccini.MarshalCSV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Marshal {

    public static void main(String[] args) throws Exception {
        URL oracle = new URL("https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-regioni/dpc-covid19-ita-regioni-latest.csv");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        inputLine = in.readLine();
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);3 12
            String[] attributes = inputLine.split(",");


        }

            in.close();
    }
}
