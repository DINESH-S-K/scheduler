package com.ruleengine.scheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Schedule {
    private String daily;
    private List<String> custom;
}
