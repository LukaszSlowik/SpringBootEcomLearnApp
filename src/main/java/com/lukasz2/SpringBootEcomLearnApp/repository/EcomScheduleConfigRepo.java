package com.lukasz2.SpringBootEcomLearnApp.repository;

import com.lukasz2.SpringBootEcomLearnApp.model.ScheduleConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EcomScheduleConfigRepo extends JpaRepository<ScheduleConfig, Long> {
    Optional<ScheduleConfig> findByTaskName(String taskName);
}
