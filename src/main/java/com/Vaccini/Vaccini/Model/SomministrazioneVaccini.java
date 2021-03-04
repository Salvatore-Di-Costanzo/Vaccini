package com.Vaccini.Vaccini.Model;

import lombok.*;

import javax.persistence.*;

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
    private Integer index;

    @Column(name="data_somministrazione")
    private String data;

    @Column(name="area")
    private String area;

    @Column(name="totale")
    private Integer totale;

    @Column(name="sesso_maschile")
    private Integer sesso_maschile;

    @Column(name="sesso_femminile")
    private Integer sesso_femminile;

    @Column(name="categoria_operatori_sanitari_sociosanitari")
    private Integer categoria_operatori_sanitari_sociosanitari;

    @Column(name="categoria_personale_non_sanitario")
    private Integer categoria_personale_non_sanitario;

    @Column(name="categoria_ospiti_rsa")
    private Integer categoria_ospiti_rsa;

    @Column(name="categoria_over80")
    private Integer categoria_over80;

    @Column(name="categoria_forze_armate")
    private Integer categoria_forze_armate;

    @Column(name="categoria_personale_scolastico")
    private Integer categoria_personale_scolastico;

    @Column(name="prima_dose")
    private Integer prima_dose;

    @Column(name="seconda_dose")
    private Integer seconda_dose;

    @Column(name="codice_NUTS1")
    private String codice_NUTS1;

    @Column(name="codice_NUTS2")
    private String codice_NUTS2;

    @Column(name="codice_regione_ISTAT")
    private Integer codice_regione_ISTAT;

    @Column(name="nome_area")
    private String nome_area;


}
