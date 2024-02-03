package com.naturaldisasterbackend.demo.database;

import java.sql.Statement;
import java.sql.Connection;

import java.io.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.naturaldisasterbackend.demo.model.Disasters;
import com.naturaldisasterbackend.demo.utils.DisasterService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/disasters")
@CrossOrigin
public class DatabaseController {

    private final DisasterService ds;
    private Connection connection;
    private Statement statement;

    @Autowired
    public DatabaseController(DisasterService ds) throws IOException {
        this.ds = ds;

        File file = new File("C:\\Users\\micha\\Downloads\\MOCK_DATA.csv");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = br.readLine();

        while ((line = br.readLine()) != null){
            String[] temp = line.split(",");

            Disasters disasters = Disasters.fromString(line);
            addNewDisaster(disasters);
        }


    }
    @GetMapping("/getAllDisasters")
    public List<Disasters> getAll() {
        return ds.getAllDisasters();
    }
    @GetMapping("{disasterID}")
    public Optional<Disasters> getDisaster(@RequestParam("disasterID") int id) {
        return ds.getDisasters(id);
    }

    @GetMapping("/getDisasterByName")
    public String getDisasterByName(@RequestParam String name) {
        return ds.getDisasterByName(name);
    }

    @GetMapping("/getDisasterByType")
    public String getDisasterByType(@RequestParam String type) {
        return ds.getDisasterByName(type);
    }

    @PostMapping("/promoters")
    public void addNewDisaster(@RequestBody Disasters disaster) {
        ds.addNewDisaster(disaster);
    }

    @DeleteMapping(path = "/delete/{disasterID}")
    public void deleteDisaster(@PathVariable("disasterID") int id) {
        ds.deleteDisaster(id);
    }

}