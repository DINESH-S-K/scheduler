package com.ruleengine.scheduler.entity.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruleengine.scheduler.entity.Domain;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.io.IOException;
import java.util.List;

 @Converter
public class DomainListConverter implements AttributeConverter<List<Domain>, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<Domain> domainList) {
        try {
            return objectMapper.writeValueAsString(domainList);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Domain> convertToEntityAttribute(String json) {
        try {
            return objectMapper.readValue(json, new TypeReference<List<Domain>>() {});
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
