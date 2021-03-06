package com.Vaccini.Vaccini.MarshalCSV;

import com.Vaccini.Vaccini.DTO.RegioneContagi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import java.util.List;


@Slf4j
@Component
public class Marshal {
    public List<RegioneContagi> getDati(String data) {
        String dataMod = data.replace("-", "");
        boolean corretto = true;
        List<RegioneContagi> dati;
        final String URL_LASTES = "https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-regioni/dpc-covid19-ita-regioni-latest.csv";
        String URL_DATA = "https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-regioni/dpc-covid19-ita-regioni-" + dataMod + ".csv";

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
           corretto = false;
        }
        if (!corretto){
            dati.add(new RegioneContagi("Error",0));
        }

        return dati;
    }
}