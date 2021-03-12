package com.Vaccini.Vaccini.Repository;

import com.Vaccini.Vaccini.Model.Contagi;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import javax.websocket.server.PathParam;
import java.io.*;
import java.sql.*;
import java.util.List;

public interface ContagiRepository extends JpaRepository<Contagi, Integer> {
    File resourcesDirectory = new File("src/main/resources");
    String PATH = resourcesDirectory.getAbsolutePath();

    List<Contagi> findAll();

    @Query("Select nuovi_positivi from Contagi where id=:id")
    Integer getNuoviPositivi(@PathParam("id") Integer id);

    @Query("Select denominazione_regione from Contagi where id=:id")
    String getNomeRegioni(@PathParam("id") Integer id);



}
