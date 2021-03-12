package com.Vaccini.Vaccini.Service;

import com.Vaccini.Vaccini.Model.Contagi;
import com.Vaccini.Vaccini.Repository.ContagiRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
public class ContagiService {

    static File resourcesDirectory = new File("src/main/resources");
    static final String PATH = resourcesDirectory.getAbsolutePath();

    @Autowired
    ContagiRepository contagiRepository;

    public List<Contagi> getContagi() {

        return contagiRepository.findAll();

    }

    public Integer getNuoviPositivi(Integer i) {
        return contagiRepository.getNuoviPositivi(i);
    }

    public String positiviPerData(String data) throws IOException, SQLException {
        String dataMod = data.replace("-", "");
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
            recuperaDati();
            if (LocalDate.now().isBefore(LocalDate.parse(data)) || LocalDate.now().isEqual(LocalDate.parse(data))) {
                return "KO";
            }
        }
        fos3.getChannel().transferFrom(rbc3, 0, Long.MAX_VALUE);
        recuperaDati();
        return "OK";
    }

    public String getNomiRegioni(Integer i) {
        return contagiRepository.getNomeRegioni(i);
    }

    static void recuperaDati() throws SQLException, FileNotFoundException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:postgresql://localhost:5432/postgres";
        Connection con = DriverManager.getConnection(mysqlUrl, "postgres", "root");
        //Initialize the script runner
        ScriptRunner sr = new ScriptRunner(con);
        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader(PATH + "/reload.sql"));
        //Running the script
        sr.runScript(reader);

    }

    @Bean
    public DataSourceInitializer dataSourceInitializer(@Qualifier("dataSource") final DataSource dataSource) {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("/postgreScript.sql"));
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
        return dataSourceInitializer;
    }
}
