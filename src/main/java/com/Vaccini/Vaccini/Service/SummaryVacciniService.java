package com.Vaccini.Vaccini.Service;

import com.Vaccini.Vaccini.Model.SummaryVaccini;
import com.Vaccini.Vaccini.Repository.SummaryVacciniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SummaryVacciniService  {

    @Autowired
    SummaryVacciniRepository summaryVacciniRepository;

    public List<SummaryVaccini> getSummary () {
        return summaryVacciniRepository.findAll();
    }

    public String getNomiRegioni (Integer i) {
        return summaryVacciniRepository.nomiRegioni(i);
    }
}
