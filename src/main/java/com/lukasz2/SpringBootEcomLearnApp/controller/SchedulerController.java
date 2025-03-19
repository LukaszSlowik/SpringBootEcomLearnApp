package com.lukasz2.SpringBootEcomLearnApp.controller;

import com.lukasz2.SpringBootEcomLearnApp.Dto.CronUpdateRequestDTO;
import com.lukasz2.SpringBootEcomLearnApp.Scheduler.DynamicSchedulerService;
import com.lukasz2.SpringBootEcomLearnApp.repository.EcomScheduleConfigRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController {


    @Autowired
    private EcomScheduleConfigRepo scheduleConfigRepository;

    @Autowired
    private DynamicSchedulerService dynamicSchedulerService;


    @PostMapping("/update-cron")
    public ResponseEntity<String> updateCron(@RequestBody CronUpdateRequestDTO request) {
        dynamicSchedulerService.updateCronExpression(request.getTaskName(), request.getCronExpression());
        return ResponseEntity.ok("Cron expression updated successfully!");
    }
}


