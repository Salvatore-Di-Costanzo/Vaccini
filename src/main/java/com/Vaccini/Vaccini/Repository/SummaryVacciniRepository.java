package com.Vaccini.Vaccini.Repository;

import com.Vaccini.Vaccini.Model.SummaryVaccini;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SummaryVacciniRepository extends JpaRepository<SummaryVaccini,Integer> {

    List<SummaryVaccini> findAll();
    @Query("SELECT nome_area FROM SummaryVaccini")
    List<String> nomiRegioni ();
}
