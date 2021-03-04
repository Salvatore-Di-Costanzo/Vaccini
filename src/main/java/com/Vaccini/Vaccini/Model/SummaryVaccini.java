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
    private Integer id;

    @Column(name="area")
    private String area;

    @Column(name="dosi_somministrate")
    private Integer dosi_somministrate;

    @Column(name="dosi_consegnate")
    private Integer dosi_consegnate;

    @Column(name="percentuale_somministrazione")
    private Float percentuale_somministrazione;

    @Column(name="ultimo_aggiornamento")
    private String ultimo_aggiornamento;

    @Column(name="codice_NUTS1")
    private String codice_NUTS1;

    @Column(name="codice_NUTS2")
    private String codice_NUTS2;

    @Column(name="codice_regione_ISTAT")
    private String codice_regione_ISTAT;

    @Column(name="nome_area")
    private String nome_area;
}
