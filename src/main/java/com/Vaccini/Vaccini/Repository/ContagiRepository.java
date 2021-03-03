package com.Vaccini.Vaccini.Repository;

import com.Vaccini.Vaccini.Model.Contagi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.List;

public interface ContagiRepository extends JpaRepository<Contagi,Integer> {

    List<Contagi> findAll ();

    @Query("Select nuovi_positivi from Contagi where id=:id")
    Integer getNuoviPositivi(@PathParam("id") Integer id);
}
