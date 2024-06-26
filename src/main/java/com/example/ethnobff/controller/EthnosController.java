package com.example.ethnobff.controller;

import com.example.ethnobff.controller.EthnosWithPolygonPointsDTO;
import com.example.ethnobff.model.Ethnos;
import com.example.ethnobff.model.PolygonPoint;
import com.example.ethnobff.repository.EthnosRepository;
import com.example.ethnobff.repository.PolygonPointRepository;
import com.example.ethnobff.service.EthnosService;
import com.example.ethnobff.service.PolygonPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/ethnos")
public class EthnosController {
    @Autowired
    private EthnosRepository ethnosRepository;
    @Autowired
    private PolygonPointRepository polygonPointRepository;
    @Autowired
    private PolygonPointService polygonPointService;
    @Autowired
    private EthnosService ethnosService;

    // Метод для создания списка этносов
    @PostMapping("/list")
    public List<Ethnos> createEthnos(@RequestBody List<Ethnos> ethnosList) {
        List<Ethnos> savedEthnosList = new ArrayList<>();
        for (Ethnos ethnos : ethnosList) {
            for (PolygonPoint point : ethnos.getPolygonPoints()) {
                point.setEthnos(ethnos);
            }
            savedEthnosList.add(ethnosRepository.save(ethnos));
        }
        return savedEthnosList;
    }

    // Новый метод для создания отдельного этноса
    @PostMapping
    public Ethnos createSingleEthnos(@RequestBody Ethnos ethnos) {
        for (PolygonPoint point : ethnos.getPolygonPoints()) {
            point.setEthnos(ethnos);
        }
        return ethnosRepository.save(ethnos);
    }

    @GetMapping("/ethnos-with-polygon-points")
    public List<EthnosWithPolygonPointsDTO> getEthnosWithPolygonPoints() {
        List<Ethnos> ethnosList = ethnosService.findAll();
        List<EthnosWithPolygonPointsDTO> ethnosWithPolygonPointsList = new ArrayList<>();
        for (Ethnos ethnos : ethnosList) {
            List<PolygonPoint> polygonPoints = polygonPointService.findByEthnosId(ethnos.getId());
            EthnosWithPolygonPointsDTO ethnosWithPolygonPoints = new EthnosWithPolygonPointsDTO(ethnos, polygonPoints);
            ethnosWithPolygonPointsList.add(ethnosWithPolygonPoints);
        }
        return ethnosWithPolygonPointsList;
    }

    @DeleteMapping("/{ethnosId}")
    public void deleteEthnosWithPolygonPoints(@PathVariable Long ethnosId) {
        List<PolygonPoint> polygonPoints = polygonPointService.findByEthnosId(ethnosId); // получаем все точки полигона по ethnosId
        for (PolygonPoint point : polygonPoints) {
            polygonPointService.deleteById(point.getId()); // удаляем каждую точку полигона
        }
        ethnosService.deleteById(ethnosId); // удаляем этнос
    }

    @PutMapping("/{ethnosId}")
    public Ethnos updateEthnosData(@PathVariable Long ethnosId, @RequestBody Ethnos updatedEthnos) {
        Ethnos existingEthnos = ethnosRepository.findById(ethnosId).orElseThrow(() -> new RuntimeException("Ethnos not found with id: " + ethnosId));

        existingEthnos.setName(updatedEthnos.getName());
        existingEthnos.setDescription(updatedEthnos.getDescription());
        existingEthnos.setPhotoURL(updatedEthnos.getPhotoURL()); // Обновление поля img

        // Обновление других полей, если необходимо

        List<PolygonPoint> updatedPolygonPoints = updatedEthnos.getPolygonPoints();
        if (updatedPolygonPoints != null && !updatedPolygonPoints.isEmpty()) {
            for (PolygonPoint updatedPoint : updatedPolygonPoints) {
                updatedPoint.setEthnos(existingEthnos);
            }
            existingEthnos.setPolygonPoints(updatedPolygonPoints);
        }

        return ethnosRepository.save(existingEthnos);
    }

}