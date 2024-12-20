package com.harvest.tempmatch.facade;

import com.harvest.tempmatch.dto.TemperatureRecordDto;
import com.harvest.tempmatch.mapper.TemperatureRecordMapper;
import com.harvest.tempmatch.model.SensorState;
import com.harvest.tempmatch.service.SensorService;
import com.harvest.tempmatch.service.SensorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class SensorFacadeImpl implements SensorFacade{

    private final SensorService sensorService;
    private final TemperatureRecordMapper temperatureRecordMapper;

    public SensorState recordTemperature(Map<String, Object> payload){
        return sensorService.recordTemperature(payload);
    }

    public void updateThresholds(Map<String, Object> payload){
        sensorService.updateThresholds(payload);
    }

    public List<TemperatureRecordDto> getLast15Records(){
        return temperatureRecordMapper.mapToTemperatureRecordDtoList(sensorService.getLast15Records());
    }
}
