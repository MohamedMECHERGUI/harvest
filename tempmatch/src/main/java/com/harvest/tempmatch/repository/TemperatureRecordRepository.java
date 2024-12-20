package com.harvest.tempmatch.repository;


import com.harvest.tempmatch.model.TemperatureRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemperatureRecordRepository extends JpaRepository<TemperatureRecord, Long> {
    List<TemperatureRecord> findTop15ByOrderByTimestampDesc();
}

