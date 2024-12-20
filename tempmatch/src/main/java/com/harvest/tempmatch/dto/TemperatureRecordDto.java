package com.harvest.tempmatch.dto;

import com.harvest.tempmatch.model.SensorState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureRecordDto {
    private Long id;
    private double temperature;
    private SensorState state;
    private LocalDateTime timestamp;
}