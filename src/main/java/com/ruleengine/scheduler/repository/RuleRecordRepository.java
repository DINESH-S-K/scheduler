package com.ruleengine.scheduler.repository;

import com.ruleengine.scheduler.entity.RuleRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleRecordRepository extends JpaRepository<RuleRecord,Integer> {
    List<RuleRecord> findByNextExecutionTimeIsNull();
}
