package com.example.ethnobff.service;

import com.example.ethnobff.model.PolygonPoint;
import com.example.ethnobff.repository.PolygonPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolygonPointService {
    @Autowired
    private PolygonPointRepository polygonPointRepository;

    public List<PolygonPoint> findByEthnosId(Long ethnosId) {
        return polygonPointRepository.findByEthnosId(ethnosId);
    }

    public PolygonPoint save(PolygonPoint polygonPoint) {
        return polygonPointRepository.save(polygonPoint);
    }

    public void deleteById(Long id) {
        polygonPointRepository.deleteById(id);
    }


}