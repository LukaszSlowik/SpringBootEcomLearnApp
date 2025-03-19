package com.lukasz2.SpringBootEcomLearnApp.Scheduler;

import com.lukasz2.SpringBootEcomLearnApp.model.ScheduleConfig;
import com.lukasz2.SpringBootEcomLearnApp.repository.EcomScheduleConfigRepo;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledFuture;

@Service
public class EcomDynamicSchedulerService implements DynamicSchedulerService {


    private final EcomOrderScheduler ecomOrderScheduler;
    private final EcomScheduleConfigRepo ecomScheduleConfigRepo;
    private final ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
    private ScheduledFuture<?> scheduledFuture;

    public EcomDynamicSchedulerService(EcomOrderScheduler ecomOrderScheduler, EcomScheduleConfigRepo ecomScheduleConfigRepo) {
        this.ecomOrderScheduler = ecomOrderScheduler;
        this.ecomScheduleConfigRepo = ecomScheduleConfigRepo;
        taskScheduler.initialize();
    }


    @Override
    public void updateCronExpression(String taskName, String newCron) {
        ScheduleConfig config = ecomScheduleConfigRepo.findByTaskName(taskName)
                .orElse(new ScheduleConfig());
        config.setTaskName(taskName);
        config.setCronExpression(newCron);
        ecomScheduleConfigRepo.save(config);
        restartScheduledTask(newCron);

    }

    @Override
    public void restartScheduledTask(String cronExpression) {
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        Runnable runnableProcessPendingOrders = ecomOrderScheduler::processPendingOrders;
        scheduledFuture = taskScheduler.schedule(runnableProcessPendingOrders, new CronTrigger(cronExpression));
    }
}
