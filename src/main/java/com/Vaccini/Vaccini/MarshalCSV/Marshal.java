package com.Vaccini.Vaccini.MarshalCSV;

import com.Vaccini.Vaccini.DTO.RegioneContagi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class Marshal {

    public List<RegioneContagi> getDati(LocalDate data) throws IOException {
        List<RegioneContagi> dati = new ArrayList<>();
        boolean corretto = true;
        String dataMod = data.toString().replace("-", "");
        URL contagi = new URL("https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-regioni/dpc-covid19-ita-regioni-" + dataMod + ".csv");
        URLConnection yc = contagi.openConnection();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        } catch (IOException e) {
            corretto = false;
        }
        if (!corretto) {
            contagi = new URL("https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-regioni/dpc-covid19-ita-regioni-latest.csv");
            yc = contagi.openConnection();
            in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        }
        String inputLine;
        in.readLine();
        while ((inputLine = in.readLine()) != null) {
            String[] attributes = inputLine.split(",");
            dati.add(new RegioneContagi(attributes[3], Integer.parseInt(attributes[12])));
        }
        if (!corretto) {
            dati.add(new RegioneContagi("Error", 0));
        }
        return dati;
    }
}
