package com.harvest.tempmatch.controller;

import com.harvest.tempmatch.dto.TemperatureRecordDto;
import com.harvest.tempmatch.facade.SensorFacade;
import com.harvest.tempmatch.model.SensorState;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sensor")
@RequiredArgsConstructor
public class SensorController {

    private final SensorFacade sensorFacade;

    @PostMapping("/temperature")
    public ResponseEntity<?> setTemperature(@RequestBody Map<String, Object> payload) {
        SensorState state = sensorFacade.recordTemperature(payload);
        return ResponseEntity.ok(state);
    }

    @PostMapping("/thresholds")
    public ResponseEntity<Void> updateThresholds(@RequestBody Map<String, Object> payload) {
        sensorFacade.updateThresholds(payload);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/history")
    public ResponseEntity<List<TemperatureRecordDto>> getHistory() {
        return ResponseEntity.ok(sensorFacade.getLast15Records());
    }


}

