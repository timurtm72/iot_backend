package com.example.iot_backend.mapper; // Пакет для мапперов

import com.example.iot_backend.dto.LocationDto; // Импорт LocationDto
import com.example.iot_backend.model.object.Location; // Импорт встраиваемого класса Location
import com.example.iot_backend.utils.MapperUtil; // Импорт утилиты MapperUtil
import lombok.RequiredArgsConstructor; // Импорт аннотации Lombok для генерации конструктора для final полей
import org.springframework.stereotype.Component; // Импорт аннотации Component для регистрации бина в Spring

/**
 * Маппер для преобразования между встраиваемым классом Location и LocationDto.
 */
@Component // Указывает, что этот класс является компонентом Spring и должен быть управляем контейнером
@RequiredArgsConstructor // Генерирует конструктор с одним параметром для поля mapperUtil
public class LocationMapper implements IMapper<Location, LocationDto> { // Реализация интерфейса IMapper для Location и LocationDto

    private final MapperUtil mapperUtil; // Поле для хранения экземпляра MapperUtil, внедряется через конструктор

    /**
     * Преобразует Location в LocationDto.
     * @param location Встраиваемый объект Location
     * @return LocationDto DTO
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса
    public LocationDto toDto(Location location) { // Реализация метода преобразования в DTO
        return mapperUtil.getMapper().map(location, LocationDto.class); // Использование ModelMapper для преобразования location в LocationDto
    }

    /**
     * Преобразует LocationDto в Location.
     * @param locationDto DTO LocationDto
     * @return Location Встраиваемый объект
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса
    public Location toEntity(LocationDto locationDto) { // Реализация метода преобразования во встраиваемый объект
        return mapperUtil.getMapper().map(locationDto, Location.class); // Использование ModelMapper для преобразования locationDto в Location
    }
}