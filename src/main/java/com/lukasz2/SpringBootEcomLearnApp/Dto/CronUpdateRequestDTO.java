package com.lukasz2.SpringBootEcomLearnApp.Dto;

import lombok.Data;

@Data
public class CronUpdateRequestDTO {
    private String taskName;
    private  String cronExpression;
}
