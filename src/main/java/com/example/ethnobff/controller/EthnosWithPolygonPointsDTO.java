package com.example.ethnobff.controller;

import com.example.ethnobff.model.Ethnos;
import com.example.ethnobff.model.PolygonPoint;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class EthnosWithPolygonPointsDTO {
    private Ethnos ethnos;
    @JsonIgnore
    private List<PolygonPoint> polygonPoints;

    public EthnosWithPolygonPointsDTO(Ethnos ethnos, List<PolygonPoint> polygonPoints) {
        this.ethnos = ethnos;
        this.polygonPoints = polygonPoints;
    }

    public Ethnos getEthnos() {
        return ethnos;
    }

    public void setEthnos(Ethnos ethnos) {
        this.ethnos = ethnos;
    }

    public List<PolygonPoint> getPolygonPoints() {
        return polygonPoints;
    }

    public void setPolygonPoints(List<PolygonPoint> polygonPoints) {
        this.polygonPoints = polygonPoints;
    }
}