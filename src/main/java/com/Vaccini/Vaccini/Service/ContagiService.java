package com.Vaccini.Vaccini.Service;

import com.Vaccini.Vaccini.Model.Contagi;
import com.Vaccini.Vaccini.Repository.ContagiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContagiService {

    @Autowired
    ContagiRepository contagiRepository;

    public List<Contagi> getContagi () {

        return contagiRepository.findAll();

    }

    public Integer getNuoviPositivi(Integer i) {
        return contagiRepository.getNuoviPositivi(i);
    }

}
