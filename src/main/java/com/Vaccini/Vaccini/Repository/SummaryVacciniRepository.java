package com.Vaccini.Vaccini.Repository;

import com.Vaccini.Vaccini.Model.SummaryVaccini;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SummaryVacciniRepository extends JpaRepository<SummaryVaccini,Integer> {

    List<SummaryVaccini> findAll();
}
