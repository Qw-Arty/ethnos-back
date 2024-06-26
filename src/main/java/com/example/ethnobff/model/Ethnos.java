package com.example.ethnobff.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ethnos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String photoURL;

//    @JsonIgnore
    @OneToMany(mappedBy = "ethnos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PolygonPoint> polygonPoints;



    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public List<PolygonPoint> getPolygonPoints() {
        return polygonPoints;
    }

    public void setPolygonPoints(List<PolygonPoint> polygonPoints) {
        this.polygonPoints = polygonPoints;
    }
}