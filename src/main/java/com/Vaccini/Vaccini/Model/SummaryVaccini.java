package com.Vaccini.Vaccini.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name="SUMMARYVACCINI")
public class SummaryVaccini {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name="area")
    String area;

    @Column(name="dosi_somministrate")
    Integer dosi_somministrate;

    @Column(name="dosi_consegnate")
    Integer dosi_consegnate;

    @Column(name="percentuale_somministrazione")
    Float percentuale_somministrazione;

    @Column(name="ultimo_aggiornamento")
    String ultimo_aggiornamento;

    @Column(name="codice_NUTS1")
    String codice_NUTS1;

    @Column(name="codice_NUTS2")
    String codice_NUTS2;

    @Column(name="codice_regione_ISTAT")
    String codice_regione_ISTAT;

    @Column(name="nome_area")
    String nome_area;
}
