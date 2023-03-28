package com.ruleengine.scheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Action {
    private String type;
    private int value;
    private boolean factor;
}
