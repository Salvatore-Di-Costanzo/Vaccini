package com.Vaccini.Vaccini.MarshalCSV;

import com.Vaccini.Vaccini.DTO.RegioneContagi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class Marshal {
    @Bean
    public static List<RegioneContagi> getDati(String data) throws IOException {
        List<RegioneContagi> dati = new ArrayList<>();
        Boolean corretto = true;
        String dataMod = data.replace("-", "");
        URL contagi = new URL("https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-regioni/dpc-covid19-ita-regioni-" + dataMod + ".csv");;
        URLConnection yc = contagi.openConnection();
        BufferedReader in = null;
        try{
            in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        } catch(Exception e){
            contagi = new URL("https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-regioni/dpc-covid19-ita-regioni-latest.csv");
            yc = contagi.openConnection();
            in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            corretto = false;
        }

        String inputLine = in.readLine();
        while ((inputLine = in.readLine()) != null) {
            String[] attributes = inputLine.split(",");
            dati.add(new RegioneContagi(attributes[3],Integer.parseInt(attributes[12])));
        }
        if (!corretto){
            dati.add(new RegioneContagi("Error",0));
        }
        return dati;
    }
}
