package com.example.ethnobff.controller;

import com.example.ethnobff.model.Ethnos;
import com.example.ethnobff.model.PolygonPoint;
import com.example.ethnobff.service.EthnosService;
import com.example.ethnobff.service.PolygonPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/polygon")
public class PolygonPointController {
    @Autowired
    private EthnosService ethnosService;
    @Autowired
    private PolygonPointService polygonPointService;

    @GetMapping
    public List<PolygonPoint> getPolygonPoints(@RequestParam Long ethnosId) {
        return polygonPointService.findByEthnosId(ethnosId);
    }

    @PostMapping("/batch/{id}")
    public List<PolygonPoint> createPolygonPoints(@PathVariable Long id, @RequestBody List<PolygonPoint> polygonPoints) {
        List<PolygonPoint> savedPoints = new ArrayList<>();
        Ethnos ethnos = ethnosService.findById(id); // получаем Ethnos по id
        for (PolygonPoint point : polygonPoints) {
            point.setEthnos(ethnos); // устанавливаем связь с Ethnos
            savedPoints.add(polygonPointService.save(point)); // сохраняем точку полигона
        }
        return savedPoints;
    }

    @PostMapping
    public PolygonPoint createPolygonPoint(@RequestBody PolygonPoint polygonPoint) {
        return polygonPointService.save(polygonPoint);
    }

    @PutMapping("/{id}")
    public List<PolygonPoint> createPolygon(@PathVariable Long id, @RequestBody List<PolygonPoint> polygonPoints) {
        List<PolygonPoint> savedPolygonPoints = new ArrayList<>();
        Ethnos ethnos = ethnosService.findById(id); // получаем Ethnos по id
        for (PolygonPoint point : polygonPoints) {
            point.setEthnos(ethnos); // устанавливаем связь с Ethnos
            savedPolygonPoints.add(polygonPointService.save(point)); // сохраняем точку полигона
        }
        return savedPolygonPoints;
    }

    @DeleteMapping()
    public void deletePolygon(@RequestParam Long ethnosId) {
        List<PolygonPoint> polygonPoints = polygonPointService.findByEthnosId(ethnosId); // получаем все точки полигона по ethnosId
        for (PolygonPoint point : polygonPoints) {
            polygonPointService.deleteById(point.getId()); // удаляем каждую точку полигона
        }
    }

//    @PutMapping("/change/{id}")
//    public List<PolygonPoint> changePolygon(@PathVariable Long id, @RequestBody List<PolygonPoint> polygonPoints)
}