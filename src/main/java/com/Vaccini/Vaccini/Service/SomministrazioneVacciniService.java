package com.Vaccini.Vaccini.Service;



import com.Vaccini.Vaccini.Model.SomministrazioneVaccini;
import com.Vaccini.Vaccini.Repository.SomministrazioneVacciniRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@NoArgsConstructor
public class SomministrazioneVacciniService {

    @Autowired
    SomministrazioneVacciniRepository somministrazioneVacciniRepository;

    public List<SomministrazioneVaccini> retriveDatibyData(Date data){
        List<SomministrazioneVaccini> results = null;
        SimpleDateFormat dataParser = new SimpleDateFormat("yyyy-MM-dd");
        if (data != null) {
            results = somministrazioneVacciniRepository.findAllByData(dataParser.format(data));
        }
        return results;

    }

}
