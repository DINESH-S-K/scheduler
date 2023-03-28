package com.ruleengine.scheduler.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JsonDataBaseDemo{
public static void main(String[] args) {
        // Sample schedule
        String[] custom = { "2", "5-9" };

        // Get current day of the week and time
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek weekday = now.getDayOfWeek();
        LocalTime currentTime = now.toLocalTime();

        // Calculate next execution time
        LocalDateTime nextExecution = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        if (custom[weekday.getValue() - 1] != null) {
        // There is a fixed execution time for today
        LocalTime executionTime = LocalTime.parse(custom[weekday.getValue() - 1], formatter);
        if (executionTime.compareTo(currentTime) >= 0) {
        // The execution time is in the future
        nextExecution = LocalDateTime.of(now.toLocalDate(), executionTime);
        } else {
        // The execution time is in the past, look for the next one
        nextExecution = LocalDateTime.of(now.toLocalDate(), executionTime).plusDays(7);
        }
        } else {
        // Look for the next available execution time
        for (int i = 1; i <= 7; i++) {
        DayOfWeek nextDayOfWeek = weekday.plus(i);
        int index = nextDayOfWeek.getValue() - 1;
        if (custom[index] != null) {
        if (custom[index].contains("-")) {
        // There is a time range for this day
        String[] timeRange = custom[index].split("-");
        LocalTime startTime = LocalTime.parse(timeRange[0], formatter);
        LocalTime endTime = LocalTime.parse(timeRange[1], formatter);
        if (startTime.compareTo(currentTime) <= 0 && endTime.compareTo(currentTime) >= 0) {
        // The current time is within the time range
        nextExecution = LocalDateTime.of(now.toLocalDate().plusDays(i), endTime);
        break;
        }
        } else {
        // There is a fixed execution time for this day
        LocalTime executionTime = LocalTime.parse(custom[index], formatter);
        nextExecution = LocalDateTime.of(now.toLocalDate().plusDays(i), executionTime);
        if (nextExecution.compareTo(now) <= 0) {
        // The execution time is in the past, look for the next one
        nextExecution = nextExecution.plusDays(7);
        }
        break;
        }
        }
        }
        }

        System.out.println(nextExecution);
        }
        }

