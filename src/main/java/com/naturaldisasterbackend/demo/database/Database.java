package com.naturaldisasterbackend.demo.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.naturaldisasterbackend.demo.model.Disasters;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface Database extends JpaRepository<Disasters, Integer>{ // For Dependency Injection of all Database jpa actions
//    List<Disasters> findBySomething(Integer id, String name, Double longi, Double lat, LocalDate date, Integer intensity, String type);
    List<Disasters> getDisastersByName(String name);
    List<Disasters> getDisastersByType(String type);
}
