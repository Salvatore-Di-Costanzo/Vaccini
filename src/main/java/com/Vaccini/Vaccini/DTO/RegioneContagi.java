package com.Vaccini.Vaccini.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegioneContagi {
    @JsonProperty("denominazione_regione")
    String nomeRegione;
    @JsonProperty("nuovi_positivi")
    Integer numeroContagi;

}
