package com.ruleengine.scheduler.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Testing {
    private Integer id;
    private String name;
    private Integer accountId;
    private ArrayList domain;
    private String expression;
    private String window;
    private String frequency;
    private String actions;
    private String schedule;
    private String status;
    private Timestamp  createdAt;
            private Integer createdBy;
    private Timestamp  updatedAt;
    private Integer   updatedBy;
}
