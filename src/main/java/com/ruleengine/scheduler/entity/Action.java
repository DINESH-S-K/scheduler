package com.ruleengine.scheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Action {
    private String type;
    private int value;
    private boolean factor;
}
