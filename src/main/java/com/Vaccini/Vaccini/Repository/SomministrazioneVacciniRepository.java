package com.Vaccini.Vaccini.Repository;

import com.Vaccini.Vaccini.Model.SomministrazioneVaccini;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SomministrazioneVacciniRepository extends JpaRepository<SomministrazioneVaccini, Integer> {

    List<SomministrazioneVaccini> findAllByData(String data);
}
