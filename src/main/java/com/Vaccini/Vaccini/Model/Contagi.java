package com.Vaccini.Vaccini.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Contagi")
public class Contagi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="data")
    private String data;

    @Column(name="stato")
    private String stato;

    @Column(name="codice_regione")
    private Integer codice_regione;

    @Column(name="denominazione_regione")
    private String denominazione_regione;

    @Column(name = "lat")
    private Float latitudine;

    @Column(name = "long")
    private Float longitudine;

    @Column(name = "ricoverati_con_sintomi")
    private Integer ricoverati_con_sintomi;

    @Column(name = "terapia_intensiva")
    private Integer terapia_intensiva;

    @Column(name = "totale_ospedalizzati")
    private Integer totale_ospedalizzati;

    @Column(name = "isolamento_domiciliare")
    private Integer isolamento_domiciliare;

    @Column(name = "totale_positivi")
    private Integer totale_positivi;

    @Column(name = "variazione_totale_positivi")
    private Integer variazione_totale_positivi;

    @Column(name = "nuovi_positivi")
    private Integer nuovi_positivi;

    @Column(name = "dimessi_guariti")
    private Integer dimessi_guariti;

    @Column(name = "deceduti")
    private Integer deceduti;

    @Column(name = "casi_da_sospetto_diagnostico")
    private Integer casi_da_sospetto_diagnostico;

    @Column(name = "casi_da_screening")
    private Integer casi_da_screening;

    @Column(name = "totale_casi")
    private Integer totale_casi;

    @Column(name = "tamponi")
    private Integer tamponi;

    @Column(name = "casi_testati")
    private Integer casi_testati;

    @Column(name = "note")
    private String note;

    @Column(name = "ingressi_terapia_intensiva")
    private Integer ingressi_terapia_intensiva;

    @Column(name = "note_test")
    private String note_test;

    @Column(name = "note_casi")
    private String note_casi;

    @Column(name = "totale_positivi_test_molecolare")
    private Integer totale_positivi_test_molecolare;

    @Column(name = "totale_positivi_test_antigenico_rapido")
    private Integer totale_positivi_test_antigenico_rapido;

    @Column(name = "tamponi_test_molecolare")
    private Integer tamponi_test_molecolare;

    @Column(name = "tamponi_test_antigenico_rapido")
    private Integer tamponi_test_antigenico_rapido;

    @Column(name = "codice_nuts_1")
    private String codice_nuts_1;

    @Column(name = "codice_nuts_2")
    private String codice_nuts_2;
}
