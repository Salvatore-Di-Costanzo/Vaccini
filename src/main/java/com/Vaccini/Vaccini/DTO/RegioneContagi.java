package com.Vaccini.Vaccini.DTO;

import lombok.*;
import org.springframework.stereotype.Component;



@Component
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegioneContagi {
    String nomeRegione;
    Integer numeroContagi;

}
