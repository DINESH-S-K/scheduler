package com.ruleengine.scheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public  class Domain {
    private String field;
    private String op;
    private Object value;
}
