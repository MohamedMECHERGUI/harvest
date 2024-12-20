package com.harvest.tempmatch.mapper;



import com.harvest.tempmatch.model.TemperatureRecord;
import com.harvest.tempmatch.dto.TemperatureRecordDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemperatureRecordMapper {

    public TemperatureRecordDto mapToTemperatureRecordDto(TemperatureRecord temperatureRecord) {
        return new TemperatureRecordDto(temperatureRecord.getId(), temperatureRecord.getTemperature(), temperatureRecord.getState(), temperatureRecord.getTimestamp());
    }

    public List<TemperatureRecordDto> mapToTemperatureRecordDtoList(List<TemperatureRecord> temperatureRecords) {
        List<TemperatureRecordDto> temperatureRecordDtos = new ArrayList<>();
        for (TemperatureRecord temperatureRecord : temperatureRecords) temperatureRecordDtos.add(mapToTemperatureRecordDto(temperatureRecord));
        return temperatureRecordDtos;
    }

}
