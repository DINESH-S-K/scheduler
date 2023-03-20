package com.ruleengine.scheduler.entity.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruleengine.scheduler.entity.Expression;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ExpressionConverter implements AttributeConverter<Expression, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Expression expression) {
        try {
            return objectMapper.writeValueAsString(expression);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting Expression to JSON", e);
        }
    }

    @Override
    public Expression convertToEntityAttribute(String json) {
        try {
            return objectMapper.readValue(json, Expression.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting JSON to Expression", e);
        }
    }
}

