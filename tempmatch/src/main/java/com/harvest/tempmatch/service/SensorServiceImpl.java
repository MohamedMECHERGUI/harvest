package com.harvest.tempmatch.service;


import com.harvest.tempmatch.model.SensorState;
import com.harvest.tempmatch.model.TemperatureRecord;
import com.harvest.tempmatch.repository.TemperatureRecordRepository;
import com.harvest.tempmatch.util.SensorStateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService{
    private final TemperatureRecordRepository repository;
    private double hotThreshold = 40.0;
    private double coldThreshold = 22.0;

    public SensorState recordTemperature(Map<String, Object> payload) {
        Double temperature = (Double) payload.get("temperature");
        SensorState state =  SensorStateUtil.getTempState(temperature, hotThreshold, coldThreshold);
        TemperatureRecord record = TemperatureRecord.builder()
                .temperature(temperature)
                .state(state)
                .timestamp(LocalDateTime.now())
                .build();
        repository.save(record);
        return state;
    }

    public List<TemperatureRecord> getLast15Records() {
        return repository.findTop15ByOrderByTimestampDesc();
    }

    public void updateThresholds(Map<String, Object> payload) {
        this.hotThreshold = (Double) payload.get("hot");
        this.coldThreshold = (Double) payload.get("cold");
    }

}

