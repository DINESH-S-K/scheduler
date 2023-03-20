package com.ruleengine.scheduler.jobscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobScheduler {

    @Scheduled(cron = "0/10 * * * * ?")
    public void scheduleJob() {
        // Trigger your job here
    }
}
