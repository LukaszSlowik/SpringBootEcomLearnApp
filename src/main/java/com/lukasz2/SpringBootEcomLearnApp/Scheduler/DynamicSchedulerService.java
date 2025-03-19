package com.lukasz2.SpringBootEcomLearnApp.Scheduler;

public interface DynamicSchedulerService {
    void updateCronExpression(String taskName, String newCron);
    void restartScheduledTask(String cronExpression);

}
