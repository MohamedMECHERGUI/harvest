package com.harvest.tempmatch.facade;

import com.harvest.tempmatch.dto.TemperatureRecordDto;
import com.harvest.tempmatch.model.SensorState;


import java.util.List;
import java.util.Map;

public interface SensorFacade {

    SensorState recordTemperature(Map<String, Object> payload);
    void updateThresholds(Map<String, Object> payload);
    List<TemperatureRecordDto> getLast15Records();
}
