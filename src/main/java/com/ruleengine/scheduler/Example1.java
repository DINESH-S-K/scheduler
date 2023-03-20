package com.ruleengine.scheduler;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example1{
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(); // current date and time
        int currentDayOfWeek = now.getDayOfWeek().getValue(); // get the current day of the week (0 = Sunday, 6 = Saturday)

        LocalTime nextExecutionTime = getNextExecutionTime(currentDayOfWeek, now.toLocalTime(), Arrays.asList("2", "5-9")); // custom array of time intervals

        LocalDateTime nextExecutionDateTime = LocalDateTime.of(now.toLocalDate(), nextExecutionTime);
        if (nextExecutionDateTime.isBefore(now)) {
            // if the next execution time is in the past, add one week to the date
            nextExecutionDateTime = nextExecutionDateTime.plusWeeks(1);
        }
        System.out.println("Next execution time: " + nextExecutionDateTime);
    }

    public static LocalTime getNextExecutionTime(int currentDayOfWeek, LocalTime currentTime, List<String> custom) {
        LocalTime nextExecutionTime = null;
        String currentDaySchedule = custom.get(currentDayOfWeek);
        if (currentDaySchedule != null) {
            // if the current day has a schedule, parse the time intervals
            List<LocalTime[]> timeIntervals = parseTimeIntervals(currentDaySchedule);
            for (LocalTime[] interval : timeIntervals) {
                LocalTime startTime = interval[0];
                LocalTime endTime = interval[1];
                if (currentTime.isBefore(startTime) || currentTime.equals(startTime)) {
                    // if the current time is before or equal to the start time, the next execution time is the start time
                    nextExecutionTime = startTime;
                    break;
                } else if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
                    // if the current time is after the start time and before the end time, the next execution time is the end time
                    nextExecutionTime = endTime;
                    break;
                }
            }
            if (nextExecutionTime == null) {
                // if the current time is after the last time interval, the next execution time is the first interval of the next day
                nextExecutionTime = parseTimeIntervals(custom.get((currentDayOfWeek + 1) % 7)).get(0)[0];
            }
        } else {
            // if the current day does not have a schedule, the next execution time is the first interval of the next day
            nextExecutionTime = parseTimeIntervals(custom.get((currentDayOfWeek + 1) % 7)).get(0)[0];
        }
        return nextExecutionTime;
    }

    public static List<LocalTime[]> parseTimeIntervals(String schedule) {
        List<LocalTime[]> timeIntervals = new ArrayList<>();
        String[] parts = schedule.split(",");
        for (String part : parts) {
            String[] interval = part.split("-");
            LocalTime startTime = LocalTime.parse(interval[0] + ":00");
            LocalTime endTime = interval.length > 1 ? LocalTime.parse(interval[1] + ":00") : startTime.plusHours(1);
            timeIntervals.add(new LocalTime[] {startTime, endTime});
        }
        return timeIntervals;
    }
}

