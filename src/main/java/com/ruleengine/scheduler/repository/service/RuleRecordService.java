package com.ruleengine.scheduler.repository.service;

import com.ruleengine.scheduler.entity.RuleRecord;
import com.ruleengine.scheduler.entity.Schedule;
import com.ruleengine.scheduler.repository.RuleRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RuleRecordService {
    @Autowired
    private RuleRecordRepository ruleRecordRepository;

    public void save(RuleRecord ruleRecord) {
        ruleRecordRepository.save(ruleRecord);
    }

    public List<RuleRecord> getAllRules() {
        return ruleRecordRepository.findAll();
    }

    public List<RuleRecord> getSchedulesWithNullNextExecution() {
        //        List<Schedule> schedules = new ArrayList<>();
//        for (RuleRecord ruleRecord : ruleRecords) {
//            Schedule schedule =  ruleRecord.getSchedule();
//            schedules.add(schedule);
//        }
//        return schedules;
        return ruleRecordRepository.findByNextExecutionTimeIsNull();
    }
}

