package com.ruleengine.scheduler.entity.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruleengine.scheduler.entity.Schedule;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ScheduleConverter implements AttributeConverter<Schedule, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Schedule schedule) {
        try {
            return objectMapper.writeValueAsString(schedule);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting Schedule to JSON", e);
        }
    }

    @Override
    public Schedule convertToEntityAttribute(String json) {
        try {
            return objectMapper.readValue(json, Schedule.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting JSON to Schedule", e);
        }
    }
}

