package com.example.iot_backend.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Утилитарный класс для маппинга объектов между различными классами.
 * Используется для преобразования между моделями и DTO.
 */
@Component
public class MapperUtil {
    /**
     * Объект маппера для преобразования объектов
     */
    private final ModelMapper mapper;

    /**
     * Конструктор с внедрением зависимости ModelMapper
     * @param mapper экземпляр ModelMapper
     */
    public MapperUtil(ModelMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Преобразует список объектов одного типа в список объектов другого типа
     * @param source исходный список
     * @param targetClass целевой класс
     * @return список преобразованных объектов
     * @param <S> тип исходных объектов
     * @param <T> тип целевых объектов
     */
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> mapper.map(element, targetClass))
                .toList();
    }

    /**
     * Возвращает новый экземпляр ModelMapper
     * @return новый экземпляр ModelMapper
     */
    public ModelMapper getMapper() {
        return new ModelMapper();
    }
}
