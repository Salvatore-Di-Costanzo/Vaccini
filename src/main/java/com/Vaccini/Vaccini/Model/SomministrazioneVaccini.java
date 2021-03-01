package com.Vaccini.Vaccini.Model;

import lombok.*;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "SOMMINISTRAZIONEVACCINI")
public class SomministrazioneVaccini {

    // Struttura
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer index;

    @Column(name="data_somministrazione")
    String data;

    @Column(name="area")
    String area;

    @Column(name="totale")
    Integer totale;

    @Column(name="sesso_maschile")
    Integer sesso_maschile;

    @Column(name="sesso_femminile")
    Integer sesso_femminile;

    @Column(name="categoria_operatori_sanitari_sociosanitari")
    Integer categoria_operatori_sanitari_sociosanitari;

    @Column(name="categoria_personale_non_sanitario")
    Integer categoria_personale_non_sanitario;

    @Column(name="categoria_ospiti_rsa")
    Integer categoria_ospiti_rsa;

    @Column(name="categoria_over80")
    Integer categoria_over80;

    @Column(name="categoria_forze_armate")
    Integer categoria_forze_armate;

    @Column(name="categoria_personale_scolastico")
    Integer categoria_personale_scolastico;

    @Column(name="prima_dose")
    Integer prima_dose;

    @Column(name="seconda_dose")
    Integer seconda_dose;

    @Column(name="codice_NUTS1")
    String codice_NUTS1;

    @Column(name="codice_NUTS2")
    String codice_NUTS2;

    @Column(name="codice_regione_ISTAT")
    Integer codice_regione_ISTAT;

    @Column(name="nome_area")
    String nome_area;

    /*@Override
    public String toString(){
        return "Data Somministrazione: " + this.data_somministrazione + " " +
                "Regione: " + this.nome_area + " " +
                "Totale: "+ this.totale ;
    }*/



}
