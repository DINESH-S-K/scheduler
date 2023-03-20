package com.ruleengine.scheduler.entity;

import com.ruleengine.scheduler.entity.converter.ActionListConverter;
import com.ruleengine.scheduler.entity.converter.DomainListConverter;
import com.ruleengine.scheduler.entity.converter.ExpressionConverter;
import com.ruleengine.scheduler.entity.converter.ScheduleConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rule_record")
public class RuleRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "domain")
    @Convert(converter = DomainListConverter.class)
    private List<Domain> domain;

    @Column(name = " expression")
    @Convert(converter = ExpressionConverter.class)
    private Expression expression;

    @Column(name = "`window`")
    private String window;

    @Column(name = "frequency")
    private String frequency;

    @Column(name = "actions")
    @Convert(converter = ActionListConverter.class)
    private List<Action> actions;

    @Column(name = "schedule")
    @Convert(converter = ScheduleConverter.class)
    private Schedule schedule;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private int createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private int updatedBy;

    @Column(name = "next_execution_time")
    private LocalDateTime nextExecutionTime;
}
