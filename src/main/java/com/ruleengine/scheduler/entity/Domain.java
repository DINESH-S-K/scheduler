package com.ruleengine.scheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public  class Domain {
    private String field;
    private String op;
    private Object value;
}
