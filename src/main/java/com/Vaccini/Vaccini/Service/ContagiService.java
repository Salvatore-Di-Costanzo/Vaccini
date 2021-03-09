package com.Vaccini.Vaccini.Service;

import com.Vaccini.Vaccini.Model.Contagi;
import com.Vaccini.Vaccini.Repository.ContagiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
public class ContagiService {

    File resourcesDirectory = new File("src/main/resources");
    final String PATH = resourcesDirectory.getAbsolutePath();

    @Autowired
    ContagiRepository contagiRepository;

    public List<Contagi> getContagi() {

        return contagiRepository.findAll();

    }

    public Integer getNuoviPositivi(Integer i) {
        return contagiRepository.getNuoviPositivi(i);
    }

    public String positiviPerData(String data) throws IOException, SQLException {
       String dataMod = data.replace("-","");
        URL contagi = new URL("https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-regioni/dpc-covid19-ita-regioni-" + dataMod + ".csv");
        log.info(contagi.toString());
        FileOutputStream fos3;
        ReadableByteChannel rbc3;

        try {
            rbc3 = Channels.newChannel(contagi.openStream());
            fos3 = new FileOutputStream(PATH + "\\datiContagi.csv");
        } catch (FileNotFoundException e) {
            contagi = new URL("https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-regioni/dpc-covid19-ita-regioni-latest.csv");
            log.info(contagi.toString());
            rbc3 = Channels.newChannel(contagi.openStream());
            fos3 = new FileOutputStream(PATH + "\\datiContagi.csv");
            fos3.getChannel().transferFrom(rbc3, 0, Long.MAX_VALUE);
            ContagiRepository.recuperaDati();
            if (LocalDate.now().isBefore(LocalDate.parse(data)) || LocalDate.now().isEqual(LocalDate.parse(data))) {
                return "KO";
            }
        }
        fos3.getChannel().transferFrom(rbc3, 0, Long.MAX_VALUE);
        ContagiRepository.recuperaDati();
        return "OK";
    }

}
