package com.ruleengine.scheduler.entity.rule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public  class Definition{
    private Expression expression;

    private String window;

    private String frequency;

    private List<Actions> actions;

    private String cap;

    private Schedule schedule;

}
