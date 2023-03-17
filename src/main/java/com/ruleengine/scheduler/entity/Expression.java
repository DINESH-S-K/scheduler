package com.ruleengine.scheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Expression {
    private String operator;
    private List<Condition> conditions;
}
