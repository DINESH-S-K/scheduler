package com.ruleengine.scheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class RuleRecord {
    private int id;
    private String name;
    private int accountId;
    private List<Domain> domain;
    private Expression expression;
    private String window;
    private String frequency;
    private List<Action> actions;
    private Schedule schedule;
    private String status;
    private LocalDateTime createdAt;
    private int createdBy;
    private LocalDateTime updatedAt;
    private int updatedBy;
}


