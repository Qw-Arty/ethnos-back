package com.example.ethnobff.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class PolygonPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;
    private double longitude;

    @ManyToOne
    @JoinColumn(name = "ethnos_id")
    private Ethnos ethnos;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

//    public Ethnos getEthnos() {
//        return ethnos;
//    }
//
    public void setEthnos(Ethnos ethnos) {
        this.ethnos = ethnos;
    }
}