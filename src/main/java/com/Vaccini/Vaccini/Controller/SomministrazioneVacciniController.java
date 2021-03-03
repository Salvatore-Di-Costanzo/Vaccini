package com.Vaccini.Vaccini.Controller;

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
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class SomministrazioneVacciniController {

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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/nomiRegioni")
    public List<String> nomiRegioni(){
        return summaryVacciniService.getNomiRegioni();
    }
}
