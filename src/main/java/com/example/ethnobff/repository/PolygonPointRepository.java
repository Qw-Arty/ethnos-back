package com.example.ethnobff.repository;

import com.example.ethnobff.model.PolygonPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolygonPointRepository extends JpaRepository<PolygonPoint, Long> {
    List<PolygonPoint> findByEthnosId(Long ethnosId);

}