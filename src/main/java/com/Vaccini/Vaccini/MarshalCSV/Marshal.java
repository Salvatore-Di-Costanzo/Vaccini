package com.Vaccini.Vaccini.MarshalCSV;

import com.Vaccini.Vaccini.DTO.RegioneContagi;
import com.Vaccini.Vaccini.model.CsvBean;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
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
        List<RegioneContagi> dati = new ArrayList<>();
        boolean corretto = true;
        String dataMod = data.replace("-", "");
        String URL = "https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-json/";

        WebClient webClient = WebClient.builder()
                .baseUrl(URL)
                .exchangeStrategies(ExchangeStrategies.builder().codecs(configurer ->{
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
                    configurer.customCodecs().decoder(new Jackson2JsonDecoder(mapper, MimeTypeUtils.parseMimeType(MediaType.TEXT_PLAIN_VALUE)));
                }).build())

                .build();

        Flux<CsvBean[]> bean = webClient.get()
                .uri("dpc-covid19-ita-regioni-latest.json")
                .accept(MediaType.TEXT_PLAIN)
                .retrieve()
                .bodyToFlux(CsvBean[].class)
                .log();

        bean.subscribe(System.out::println);
        return null;


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