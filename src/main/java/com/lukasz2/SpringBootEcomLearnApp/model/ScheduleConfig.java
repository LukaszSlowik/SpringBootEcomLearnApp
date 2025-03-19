package com.lukasz2.SpringBootEcomLearnApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="schedule_config")
public class ScheduleConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private  String taskName;
    private  String cronExpression;

}
