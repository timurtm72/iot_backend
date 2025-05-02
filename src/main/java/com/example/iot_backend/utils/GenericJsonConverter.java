package com.example.iot_backend.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Converter
public class GenericJsonConverter<T> implements AttributeConverter<T, String> {

    private final Class<T> clazz;
    private final ObjectMapper objectMapper;

    public GenericJsonConverter(Class<T> clazz) {
        this.clazz = clazz;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public String convertToDatabaseColumn(T attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting to JSON", e);
        }
    }

    @Override
    public T convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, clazz);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error reading JSON", e);
        }
    }
}