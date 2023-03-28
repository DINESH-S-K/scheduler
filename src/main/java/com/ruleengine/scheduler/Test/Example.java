package com.ruleengine.scheduler.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(); // current date and time
        DayOfWeek dayOfWeek = now.getDayOfWeek(); // get the current day of the week
        int dayIndex = dayOfWeek.getValue() ; // get the array index for the current day
        List<String> intervals = Arrays.asList("2", "5-9"); // custom time intervals for each day of the week
        String intervalString = intervals.get(1); // get the interval string for the current day
        LocalTime nextExecutionTime = getNextExecutionTime(intervalString, now.toLocalTime());
        LocalDateTime nextExecutionDateTime = LocalDateTime.of(now.toLocalDate(), nextExecutionTime);
        System.out.println("Next execution time: " + nextExecutionDateTime);
    }

    public static LocalTime getNextExecutionTime(String intervalString, LocalTime currentTime) {
        String[] parts = intervalString.split(",");
        for (String part : parts) {
            if (part.contains("-")) {
                String[] range = part.split("-");
                int start = Integer.parseInt(range[0]);
                int end = Integer.parseInt(range[1]);
                if (start <= currentTime.getHour() && currentTime.getHour() <= end) {
                    // the current time is within this interval, so the next execution time is the end of the interval
                    return LocalTime.of(end, 0);
                } else if (start > currentTime.getHour()) {
                    // the current time is before this interval, so the next execution time is the start of the interval
                    return LocalTime.of(start, 0);
                }
            } else {
                int fixedHour = Integer.parseInt(part);
                if (currentTime.getHour() < fixedHour) {
                    // the current time is before the fixed hour, so the next execution time is the fixed hour
                    return LocalTime.of(fixedHour, 0);
                }
            }
        }
        // if none of the intervals match, the next execution time is the start of the first interval
        String firstInterval = parts[0];
        if (firstInterval.contains("-")) {
            String[] range = firstInterval.split("-");
            int start = Integer.parseInt(range[0]);
            return LocalTime.of(start, 0);
        } else {
            int fixedHour = Integer.parseInt(firstInterval);
            return LocalTime.of(fixedHour, 0);
        }
    }
}

