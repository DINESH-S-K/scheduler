package com.ruleengine.scheduler.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Arrays;

public class Day {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(); // current date and time
        int currentDayOfWeek = now.getDayOfWeek().getValue(); // get the current day of the week (1 = Monday, 7 = Sunday)
        int todayIndex = currentDayOfWeek-1;
        List<String> values = Arrays.asList(null, null, null, null, null, "1-2", null);
        String nextValue = getNextNonNullValue(todayIndex, values);
        System.out.println("Today index: " + todayIndex);
        System.out.println("Next non-null value: " + nextValue);
    }


    public static String getNextNonNullValue(int todayIndex, List<String> values) {
        // get the next non-null value in the list, or the first value if the current day is the last index
        String nextValue = null;
        int index = todayIndex;
        nextValue = values.get(todayIndex);
        if (nextValue==null) {
            do {
                index = (index + 1) % values.size();
                nextValue = values.get(index);
            } while (nextValue == null && index != todayIndex);
            return nextValue;
        }
        return nextValue;
    }
}
