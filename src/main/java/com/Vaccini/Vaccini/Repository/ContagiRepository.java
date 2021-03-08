package com.Vaccini.Vaccini.Repository;

import com.Vaccini.Vaccini.Model.Contagi;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.codehaus.plexus.util.StringUtils;
import org.h2.tools.RunScript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import javax.sql.DataSource;
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

    static void recuperaDati() throws SQLException, FileNotFoundException {
        DriverManager.registerDriver(new org.h2.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:h2:~/test";
        Connection con = DriverManager.getConnection(mysqlUrl, "sa","password");
        System.out.println("Connection established......");
        //Initialize the script runner
        ScriptRunner sr = new ScriptRunner(con);
        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader(PATH+"/reload.sql"));
        //Running the script
        sr.runScript(reader);

    }

}
