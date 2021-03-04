package com.Vaccini.Vaccini.Model;

import com.sun.javafx.beans.IDProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

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
    Integer id;

    @Column(name="data")
    String data;

    @Column(name="stato")
    String stato;

    @Column(name="codice_regione")
    Integer codice_regione;

    @Column(name="denominazione_regione")
    String denominazione_regione;

    @Column(name = "lat")
    Float latitudine;

    @Column(name = "long")
    Float longitudine;

    @Column(name = "ricoverati_con_sintomi")
    Integer ricoverati_con_sintomi;

    @Column(name = "terapia_intensiva")
    Integer terapia_intensiva;

    @Column(name = "totale_ospedalizzati")
    Integer totale_ospedalizzati;

    @Column(name = "isolamento_domiciliare")
    Integer isolamento_domiciliare;

    @Column(name = "totale_positivi")
    Integer totale_positivi;

    @Column(name = "variazione_totale_positivi")
    Integer variazione_totale_positivi;

    @Column(name = "nuovi_positivi")
    Integer nuovi_positivi;

    @Column(name = "dimessi_guariti")
    Integer dimessi_guariti;

    @Column(name = "deceduti")
    Integer deceduti;

    @Column(name = "casi_da_sospetto_diagnostico")
    Integer casi_da_sospetto_diagnostico;

    @Column(name = "casi_da_screening")
    Integer casi_da_screening;

    @Column(name = "totale_casi")
    Integer totale_casi;

    @Column(name = "tamponi")
    Integer tamponi;

    @Column(name = "casi_testati")
    Integer casi_testati;

    @Column(name = "note")
    String note;

    @Column(name = "ingressi_terapia_intensiva")
    Integer ingressi_terapia_intensiva;

    @Column(name = "note_test")
    String note_test;

    @Column(name = "note_casi")
    String note_casi;

    @Column(name = "totale_positivi_test_molecolare")
    Integer totale_positivi_test_molecolare;

    @Column(name = "totale_positivi_test_antigenico_rapido")
    Integer totale_positivi_test_antigenico_rapido;

    @Column(name = "tamponi_test_molecolare")
    Integer tamponi_test_molecolare;

    @Column(name = "tamponi_test_antigenico_rapido")
    Integer tamponi_test_antigenico_rapido;

    @Column(name = "codice_nuts_1")
    String codice_nuts_1;

    @Column(name = "codice_nuts_2")
    String codice_nuts_2;
}
