package com.ruleengine.scheduler;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Daily {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(); // current date and time
        LocalDateTime nextExecutionDateTime = LocalDateTime.of(now.toLocalDate(), LocalTime.of(8, 0));
        if (nextExecutionDateTime.isBefore(now)) {
            // if the next execution time is in the past, add one day to the date
            nextExecutionDateTime = nextExecutionDateTime.plusDays(1);
        }
        System.out.println("Next execution time: " + nextExecutionDateTime);
    }
}


