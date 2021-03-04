package com.Vaccini.Vaccini.Controller;

import com.Vaccini.Vaccini.DTO.RegioneContagi;
import com.Vaccini.Vaccini.Model.Contagi;
import com.Vaccini.Vaccini.Model.SomministrazioneVaccini;
import com.Vaccini.Vaccini.Model.SummaryVaccini;
import com.Vaccini.Vaccini.Service.ContagiService;
import com.Vaccini.Vaccini.Service.SomministrazioneVacciniService;
import com.Vaccini.Vaccini.Service.SummaryVacciniService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class DataController {

    @Autowired
    SomministrazioneVacciniService somministrazioneVacciniService;

    @Autowired
    SummaryVacciniService summaryVacciniService;

    @Autowired
    ContagiService contagiService;

    @GetMapping("/vacciniOggi")
    public List<SomministrazioneVaccini> vacciniOggi() {
        List<SomministrazioneVaccini> somministrazioneVaccini = somministrazioneVacciniService.retriveDatibyData(new Date());;
        return somministrazioneVaccini;
    }

    @GetMapping("/vaccini")
    public List<SomministrazioneVaccini> vaccini(@RequestParam(value = "data", required = false, defaultValue = "") String data) throws ParseException {
        List<SomministrazioneVaccini> somministrazioneVaccini = null;
        if (data.isEmpty())
            somministrazioneVaccini = somministrazioneVacciniService.retriveDatibyData(new Date());
        else {
            somministrazioneVaccini = somministrazioneVacciniService.retriveDatibyData(new SimpleDateFormat("yyyy-MM-dd").parse(data));
        }
        return somministrazioneVaccini;
    }

    @GetMapping("/summaryVaccini")
    public List<SummaryVaccini> summaryVaccini() {
        return summaryVacciniService.getSummary();
    }

    @GetMapping("/contagi")
    public List<Contagi> contagi() {
       return contagiService.getContagi();
    }

    public String nomiRegioni(Integer i){
        return summaryVacciniService.getNomiRegioni(i);
    }

    public Integer nuoviPositivi(Integer i) { return contagiService.getNuoviPositivi(i); }

    @GetMapping("/regioniContagi")
    public List<RegioneContagi> getDati() {
        List<RegioneContagi> datiRegionali = new ArrayList<>();
        for(Integer i = 1; i < 22 ; i++)
            datiRegionali.add(new RegioneContagi(nomiRegioni(i),nuoviPositivi(i)));
        return datiRegionali;
    }
}