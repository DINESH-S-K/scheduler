package com.ruleengine.scheduler.jobs;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import com.ruleengine.scheduler.entity.RuleRecord;
import com.ruleengine.scheduler.repository.RuleRecordRepository;

public class UpdateNextExecutionTimeJob implements Job {
    @Autowired
    private RuleRecordRepository ruleRecordRepository;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
//JobExecutionException        // Get the current time in the time zone of the scheduler
//        ZoneId schedulerTimeZone = context.getTimeZone().toZoneId();
//        LocalDateTime now = LocalDateTime.now(schedulerTimeZone);

        // Calculate the next execution time for each rule record with a null next_execution_time
        List<RuleRecord> ruleRecords = ruleRecordRepository.findByNextExecutionTimeIsNull();
        for (RuleRecord ruleRecord : ruleRecords) {
//            LocalDateTime nextExecutionTime = ruleRecord.getSchedule().calculateNextExecutionTime(now);
//            ruleRecord.setNextExecutionTime(nextExecutionTime);
            ruleRecordRepository.save(ruleRecord);
        }
    }
}
