package com.harvest.tempmatch;


import com.harvest.tempmatch.model.SensorState;
import com.harvest.tempmatch.model.TemperatureRecord;
import com.harvest.tempmatch.repository.TemperatureRecordRepository;
import com.harvest.tempmatch.service.SensorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SensorServiceImplTest {

    private SensorServiceImpl sensorService;
    private TemperatureRecordRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(TemperatureRecordRepository.class); // Mock du repository
        sensorService = new SensorServiceImpl(repository);  // Injection du mock dans le service
    }

    @Test
    void testRecordTemperatureHotState() {
        // Préparation des données d'entrée
        Map<String, Object> payload = Map.of("temperature", 45.0);

        // Appel de la méthode à tester
        SensorState state = sensorService.recordTemperature(payload);

        // Vérification du comportement
        assertEquals(SensorState.HOT, state);
        verify(repository, times(1)).save(any(TemperatureRecord.class));  // Vérifie que save a bien été appelé
    }

    @Test
    void testRecordTemperatureWarmState() {
        // Préparation des données d'entrée
        Map<String, Object> payload = Map.of("temperature", 30.0);

        // Appel de la méthode à tester
        SensorState state = sensorService.recordTemperature(payload);

        // Vérification du comportement
        assertEquals(SensorState.WARM, state);
        verify(repository, times(1)).save(any(TemperatureRecord.class));  // Vérifie que save a bien été appelé
    }
}
