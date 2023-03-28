package com.ruleengine.scheduler.controller;

import com.ruleengine.scheduler.entity.RuleRecord;
import com.ruleengine.scheduler.repository.service.RuleRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RuleController {
    @Autowired
    private RuleRecordService service;

    @GetMapping("/rules")
    public List<RuleRecord> getRuleRecords(){
        return service.getAllRules();
    }

    @PostMapping("/rule")
    public ResponseEntity<RuleRecord> createRuleRecord(@RequestBody RuleRecord ruleRecord){
        service.save(ruleRecord);
        return ResponseEntity.ok(ruleRecord);
    }

    @GetMapping("/rules/null")
    public List<RuleRecord> getRuleRecordsWithNullExecutionTime(){
        return service.getSchedulesWithNullNextExecution();
    }
}
