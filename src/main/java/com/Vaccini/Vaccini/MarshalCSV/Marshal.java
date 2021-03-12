package com.Vaccini.Vaccini.MarshalCSV;

import com.Vaccini.Vaccini.DTO.RegioneContagi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class Marshal {
    @Bean
    public static List<RegioneContagi> getDati() throws IOException {
        List<RegioneContagi> dati = new ArrayList<>();

        URL oracle = new URL("https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-regioni/dpc-covid19-ita-regioni-latest.csv");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;
        inputLine = in.readLine();
        while ((inputLine = in.readLine()) != null) {
            String[] attributes = inputLine.split(",");
            dati.add(new RegioneContagi(attributes[3],Integer.parseInt(attributes[12])));
        }
        return dati;
    }
}
