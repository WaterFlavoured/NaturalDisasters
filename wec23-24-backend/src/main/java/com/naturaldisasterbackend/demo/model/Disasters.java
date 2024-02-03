package com.naturaldisasterbackend.demo.model;

import jakarta.persistence.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
@Entity
@Table
public class Disasters {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Double longi;
    private Double lat;
    private LocalDate date;
    private Integer intensity;
    private String type;

    public Disasters() {}

    public Disasters(Integer id, String name, Double longi, Double lat, LocalDate date, Integer intensity, String type) {
        this.id = id;
        this.name = name;
        this.longi = longi;
        this.lat = lat;
        this.date = date;
        this.intensity = intensity;
        this.type = type;
    }

    public static Disasters fromString(String val){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        String segments[] = val.split(",");
        LocalDate localDate = LocalDate.parse(segments[3], formatter);
        Disasters disasters = new Disasters(segments[0], Double.parseDouble(segments[1]), Double.parseDouble(segments[2]), localDate, Integer.parseInt(segments[4]), segments[5]);
        return disasters;
    }

    public Disasters(String name, Double longi, Double lat, LocalDate date, int intensity, String type) {
        this.name = name;
        this.longi = longi;
        this.lat = lat;
        this.date = date;
        this.intensity = intensity;
        this.type = type;
    }



    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLongi() {
        return longi;
    }

    public void setLongi(Double longi) {
        this.longi = longi;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Disaster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", longi=" + longi +
                ", lat=" + lat +
                ", date=" + date +
                ", intensity=" + intensity +
                ", type='" + type + '\'' +
                '}';
    }

    public String toSqlString() {
        return id + " '"
                + name + "' "
                + " " + longi
                + " " + lat
                + " " + date
                + " " + intensity
                + " '" + type + "'";
    }
}