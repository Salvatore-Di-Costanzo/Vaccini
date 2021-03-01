package com.Vaccini.Vaccini.Controller;

import com.Vaccini.Vaccini.Model.SomministrazioneVaccini;
import com.Vaccini.Vaccini.Service.SomministrazioneVacciniService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/db")
public class SomministrazioneVacciniController {

    @Autowired
    SomministrazioneVacciniService somministrazioneVacciniService;

    @GetMapping("/vacciniOggi")
    public void vacciniOggi (@RequestParam(value = "data",required = false,defaultValue = "")String data) throws ParseException {
        List<SomministrazioneVaccini> somministrazioneVaccini = null;
        if(data.isEmpty())
            somministrazioneVaccini = somministrazioneVacciniService.retriveDatibyData(new Date());
        else{
            somministrazioneVaccini = somministrazioneVacciniService.retriveDatibyData(new SimpleDateFormat("yyyy-MM-dd").parse(data));
        }

        if ( somministrazioneVaccini == null )
            System.out.println("\nNon sono ancora stati caricati i dati vaccinali per la giornata odierna\n");
        else {
            System.out.println("\nI dati della giornata:\n");
            System.out.println( somministrazioneVaccini );
        }

    }
}
