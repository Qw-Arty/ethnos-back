package com.example.ethnobff.service;

import com.example.ethnobff.model.PolygonPoint;
import com.example.ethnobff.repository.PolygonPointRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PolygonPointServiceTest {

    @InjectMocks
    private PolygonPointService polygonPointService;

    @Mock
    private PolygonPointRepository polygonPointRepository;

    @Test
    public void testGetPolygonPointsByEthnosId() {
        MockitoAnnotations.openMocks(this);

        Long ethnosId = 1L;
        PolygonPoint point = new PolygonPoint();
        point.setId(1L);
        point.setLatitude(42.0);
        point.setLongitude(-71.0);

        when(polygonPointRepository.findByEthnosId(ethnosId)).thenReturn(Collections.singletonList(point));

        List<PolygonPoint> points = polygonPointService.findByEthnosId(ethnosId);

        assertNotNull(points);
        // Дополнительные утверждения, если необходимо
    }
}