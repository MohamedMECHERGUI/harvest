package com.harvest.tempmatch.service;

import com.harvest.tempmatch.model.SensorState;
import com.harvest.tempmatch.model.TemperatureRecord;

import java.util.List;
import java.util.Map;

public interface SensorService {
    SensorState recordTemperature(Map<String, Object> payload);
    List<TemperatureRecord> getLast15Records() ;
    void updateThresholds(Map<String, Object> payload) ;
}
