package com.ruleengine.scheduler.jobs;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ScheduleExecution {
    public static void main(String[] args) {
        // Sample schedule
        String[] custom = { "2", "5-9", null, null, null, null, "10:30-12:30" };

        // Get current day of the week and time
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek weekday = now.getDayOfWeek();
        LocalTime currentTime = now.toLocalTime();
        Integer value = weekday.getValue();
        // Calculate next execution time
        LocalDateTime nextExecution = null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");

        if (custom[weekday.getValue() ] != null) {
            String timeInterval = custom[weekday.getValue() ];
            if (timeInterval.contains("-")) {
                // There is a time range for today
                String[] timeRange = timeInterval.split("-");
                LocalTime startTime = LocalTime.parse(timeRange[0], formatter);
                LocalTime endTime = LocalTime.parse(timeRange[1], formatter);
                if (endTime.compareTo(currentTime) <= 0) {
                    // The time range has ended for today, look for the next one
                    nextExecution = getNextRangeExecution(now, weekday, custom, formatter);
                } else if (startTime.compareTo(currentTime) <= 0) {
                    // The current time is within the time range
                    nextExecution = LocalDateTime.of(now.toLocalDate(), endTime);
                } else {
                    // The time range hasn't started yet
                    nextExecution = LocalDateTime.of(now.toLocalDate(), startTime);
                }
            } else {
                // There is a fixed execution time for today
                LocalTime executionTime = LocalTime.parse(timeInterval, formatter);
                if (executionTime.compareTo(currentTime) <= 0) {
                    // The execution time has passed for today, look for the next one
                    nextExecution = getNextFixedExecution(now, weekday, custom, formatter);
                } else {
                    // The execution time is still in the future for today
                    nextExecution = LocalDateTime.of(now.toLocalDate(), executionTime);
                }
            }
        } else {
            // Look for the next available execution time
            nextExecution = getNextRangeExecution(now, weekday, custom, formatter);
            LocalDateTime nextFixedExecution = getNextFixedExecution(now, weekday, custom, formatter);
            if (nextFixedExecution.isBefore(nextExecution)) {
                nextExecution = nextFixedExecution;
            }
        }

        System.out.println(nextExecution);
    }

    private static LocalDateTime getNextRangeExecution(LocalDateTime now, DayOfWeek weekday, String[] custom, DateTimeFormatter formatter) {
        LocalDateTime nextExecution = null;
        for (int i = 1; i <= 7; i++) {
            DayOfWeek nextDayOfWeek = weekday.plus(i);
            int index = nextDayOfWeek.getValue() - 1;
            String timeInterval = custom[index];
            if (timeInterval != null && timeInterval.contains("-")) {
                // There is a time range for this day
                String[] timeRange = timeInterval.split("-");
                LocalTime startTime = LocalTime.parse(timeRange[0], formatter);
                LocalTime endTime = LocalTime.parse(timeRange[1], formatter);
                nextExecution = LocalDateTime.of(now.toLocalDate().plusDays(i), startTime);
                if (nextExecution.compareTo(now) <= 0) {
                    // The start time has already passed for this day, use the end time instead
                    nextExecution = LocalDateTime.of(now.toLocalDate().plusDays(i), endTime);
                }
                break;
            }
        }
        if (nextExecution == null) {
            // No time range found for the next 7 days, return null
            return null;
        }
        return nextExecution;
    }

    private static LocalDateTime getNextFixedExecution(LocalDateTime now, DayOfWeek weekday, String[] custom, DateTimeFormatter formatter) {
        LocalDateTime nextExecution = null;
        for (int i = 1; i <= 7; i++) {
            DayOfWeek nextDayOfWeek = weekday.plus(i);
            int index = nextDayOfWeek.getValue() - 1;
            String timeInterval = custom[index];
            if (timeInterval != null && !timeInterval.contains("-")) {
                // There is a fixed execution time for this day
                LocalTime executionTime = LocalTime.parse(timeInterval, formatter);
                nextExecution = LocalDateTime.of(now.toLocalDate().plusDays(i), executionTime);
                if (nextExecution.compareTo(now) <= 0) {
                    // The execution time has already passed for this day, try the next one
                    nextExecution = null;
                } else {
                    // The next execution time has been found
                    break;
                }
            }
        }
        // No fixed execution time found for the next 7 days, return null
        return nextExecution;
    }
}

