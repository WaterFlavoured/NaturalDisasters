package com.naturaldisasterbackend.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import com.naturaldisasterbackend.demo.database.Database;
import com.naturaldisasterbackend.demo.model.Disasters;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class DisasterService {

    private final Database database;

    @Autowired
    public DisasterService(Database database) {
        this.database = database;
    }

    public Optional<Disasters> getDisasters(int id) {
        return database.findById(id); // Change this to something else , temp
    }

    public List<Disasters> getAllDisasters() {
        return database.findAll();
    }

    public String getDisasterByName(String name) {
        return database.getDisastersByName(name).toString();
    }

    public String getDisasterByType(String type) {
        return database.getDisastersByType(type).toString();
    }

    public void addNewDisaster(Disasters disasters) {
        database.save(disasters);
    }

    public void deleteDisaster(int id) {
        boolean exists = database.existsById(id);
        if(!exists) {
            throw new IllegalStateException("disaster with id " + id + " does not exists");
        }
        database.deleteById(id);
    }


}