package com.Vaccini.Vaccini.Repository;

import com.Vaccini.Vaccini.Model.Contagi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContagiRepository extends JpaRepository<Contagi,Integer> {

    public List<Contagi> findAll ();
}
