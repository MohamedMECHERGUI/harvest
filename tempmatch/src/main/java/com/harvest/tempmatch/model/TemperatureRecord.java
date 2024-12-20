package com.harvest.tempmatch.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TemperatureRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double temperature;

    @Enumerated(EnumType.STRING)
    private SensorState state;

    private LocalDateTime timestamp;
}

