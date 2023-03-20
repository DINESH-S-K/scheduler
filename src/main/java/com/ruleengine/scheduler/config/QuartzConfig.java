package com.ruleengine.scheduler.config;

import com.ruleengine.scheduler.jobs.UpdateNextExecutionTimeJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public Trigger myJobTrigger() {
        return TriggerBuilder.newTrigger()
//               newTrigger .forJob(updateNextExecutionTimeJob())
                .withIdentity("myJobTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")) // Run every 10 seconds
                .build();
    }

    @Bean
    public UpdateNextExecutionTimeJob updateNextExecutionTimeJob(){
        return new UpdateNextExecutionTimeJob();
    }
}

