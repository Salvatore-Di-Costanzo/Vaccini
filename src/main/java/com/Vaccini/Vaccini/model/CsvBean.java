package com.Vaccini.Vaccini.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CsvBean {

    @JsonProperty("data")
    private String data;

    @JsonProperty("stato")
    private String stato;

    @JsonProperty("codice_regione")
    private Integer codice_regione;

    @JsonProperty("denominazione_regione")
    private String denominazione_regione;

    @JsonProperty("ricoverati_con_sintomi")
    private Integer ricoverati_con_sintomi;

    @JsonProperty("terapia_intensiva")
    private Integer terapia_intensiva;

    @JsonProperty("lat")
    private Double lat;

    @JsonProperty("long")
    private Double longVar;

    @JsonProperty("totale_ospedalizzati")
    private Integer totale_ospedalizzati;

    @JsonProperty("isolamento_domiciliare")
    private Integer isolamento_domiciliare;

    @JsonProperty("totale_positivi")
    private Integer totale_positivi;

    @JsonProperty("variazione_totale_positivi")
    private Integer variazione_totale_positivi;

    @JsonProperty("nuovi_positivi")
    private Integer nuovi_positivi;

    @JsonProperty("dimessi_guariti")
    private Integer dimessi_guariti;

    @JsonProperty("deceduti")
    private Integer deceduti;

    @JsonProperty("casi_da_sospetto_diagnostico")
    private Integer casi_da_sospetto_diagnostico;

    @JsonProperty("casi_da_screening")
    private Integer casi_da_screening;

    @JsonProperty("totale_casi")
    private Integer totale_casi;

    @JsonProperty("tamponi")
    private Integer tamponi;

    @JsonProperty("casi_testati")
    private Integer casi_testati;

    @JsonProperty("note")
    private String note;

    @JsonProperty("ingressi_terapia_intensiva")
    private Integer ingressi_terapia_intensiva;

    @JsonProperty("note_test")
    private String note_test;

    @JsonProperty("note_casi")
    private String note_casi;

    @JsonProperty("totale_positivi_test_molecolare")
    private Integer totale_positivi_test_molecolare;

    @JsonProperty("totale_positivi_test_antigenico_rapido")
    private Integer totale_positivi_test_antigenico_rapido;

    @JsonProperty("tamponi_test_molecolare")
    private Integer tamponi_test_molecolare;

    @JsonProperty("tamponi_test_antigenico_rapido")
    private Integer tamponi_test_antigenico_rapido;

    @JsonProperty("codice_nuts_1")
    private String codice_nuts_1;

    @JsonProperty("codice_nuts_2")
    private String codice_nuts_2;
}