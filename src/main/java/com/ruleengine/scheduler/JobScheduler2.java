package com.ruleengine.scheduler;

import com.ruleengine.scheduler.dto.ScheduleDTO;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
// updation
public class JobScheduler2 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(); // current date and time
        int currentDayOfWeek = now.getDayOfWeek().getValue(); // get the current day of the week (0 = Monday, 6 = Sunday)
        int todayIndex = currentDayOfWeek-1;
        int dayOfMonth = now.getDayOfMonth();
        List<String> values = Arrays.asList("21-22", null, null, null, null, "1-2", null);
        LocalTime nextExecutionTime = null;

        String currentValue = values.get(todayIndex);
        if (currentValue==null) {
            ScheduleDTO scheduleDTO = getNextNonNullValue(todayIndex, values);
            nextExecutionTime = getNextExecutionTime(scheduleDTO.getValue(), now.toLocalTime());
        }else {
             nextExecutionTime = getNextExecutionTime(currentValue, now.toLocalTime());
             if(nextExecutionTime==null){
                 ScheduleDTO scheduleDTO1 = getNextNonNullValue(todayIndex, values);
                 nextExecutionTime = getNextExecutionTime(scheduleDTO1.getValue(), now.toLocalTime());
             }
        }

        LocalDateTime nextExecutionDateTime = LocalDateTime.of(now.toLocalDate(), Objects.requireNonNull(nextExecutionTime));
        System.out.println("Next execution time: " + nextExecutionDateTime);

        //        String nextValue = getNextNonNullValue(todayIndex, values);
//        int nextIndex= values.indexOf(nextValue)+1;
//
//        while(nextExecutionTime==null){
//            nextExecutionTime = getNextExecutionTime(getNextNonNullValue(nextIndex,values),now.toLocalTime());
//        }

        if (nextExecutionDateTime.isBefore(now)) {
            // if the next execution time is in the past, add one week to the date
//            nextExecutionDateTime = nextExecutionDateTime.plusWeeks(1);
        }
        System.out.println("Next execution time: " + nextExecutionDateTime);
//        System.out.println("Today index: " + todayIndex);
//        System.out.println("Next non-null value: " + nextValue);
    }

    public static LocalTime getNextExecutionTime(String intervalString, LocalTime currentTime) {
        if (intervalString.contains("-")) {
            String[] range = intervalString.split("-");
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
            int fixedHour = Integer.parseInt(intervalString);
            if (currentTime.getHour() < fixedHour) {
                // the current time is before the fixed hour, so the next execution time is the fixed hour
                return LocalTime.of(fixedHour, 0);
            }
        }
        return null;
    }
    public static ScheduleDTO getNextNonNullValue(int todayIndex, List<String> values) {
        // get the next non-null value in the list, or the first value if the current day is the last index
        String nextValue = null;
        int index = todayIndex;
        int count=0;
//        nextValue = values.get(todayIndex);
//        if (nextValue==null) {
            do {
                index = (index + 1) % values.size();
                nextValue = values.get(index);
                count +=1;
            } while (nextValue == null && index != todayIndex);
            return new ScheduleDTO(count,index,nextValue);
//        }
//        return nextValue;
    }
}

