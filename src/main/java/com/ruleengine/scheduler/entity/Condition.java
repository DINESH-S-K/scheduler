package com.ruleengine.scheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Condition {
    private String field;
    private String op;
    private Object value;
}
