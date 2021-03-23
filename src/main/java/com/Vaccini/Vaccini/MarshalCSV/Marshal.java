package com.Vaccini.Vaccini.MarshalCSV;

import com.Vaccini.Vaccini.DTO.RegioneContagi;
import com.Vaccini.Vaccini.model.CsvBean;
import com.Vaccini.Vaccini.model.CsvBean2;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Csv;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Component
public class Marshal {
    public List<RegioneContagi> getDati(String data) throws IOException {
        String dataMod = data.replace("-", "");
        List<RegioneContagi> dati;
        final String URL_LASTES = "https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-regioni/dpc-covid19-ita-regioni-latest.csv";
        String URL_DATA = "https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-regioni/dpc-covid19-ita-regioni-" + dataMod + ".csv";
        boolean corretto = true;

        String URL = "http://localhost:8080/";

        WebClient webClient = WebClient.builder()
                .baseUrl(URL)
                .build();

        Flux<RegioneContagi> bean = webClient.post()
                .uri(builder -> builder
                        .path("json")
                        .queryParam("url",URL_DATA)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(RegioneContagi.class);
        dati = bean.collectList().block();


        if (dati.isEmpty()){
           bean = webClient.post()
                    .uri(builder -> builder
                            .path("json")
                            .queryParam("url",URL_LASTES)
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToFlux(RegioneContagi.class);
           dati = bean.collectList().block();
        }

        return dati;

       /* URL contagi = new URL("https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-regioni/dpc-covid19-ita-regioni-" + dataMod + ".csv");
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
    }*/
    }
}