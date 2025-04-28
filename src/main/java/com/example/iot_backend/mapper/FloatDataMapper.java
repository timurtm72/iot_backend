package com.example.iot_backend.mapper; // Пакет для мапперов

import com.example.iot_backend.dto.FloatDataDto; // Импорт FloatDataDto
import com.example.iot_backend.model.data.FloatData; // Импорт встраиваемого класса FloatData
import com.example.iot_backend.utils.MapperUtil; // Импорт утилиты MapperUtil
import lombok.RequiredArgsConstructor; // Импорт аннотации Lombok для генерации конструктора для final полей
import org.springframework.stereotype.Component; // Импорт аннотации Component для регистрации бина в Spring

/**
 * Маппер для преобразования между встраиваемым классом FloatData и FloatDataDto.
 */
@Component // Указывает, что этот класс является компонентом Spring и должен быть управляем контейнером
@RequiredArgsConstructor // Генерирует конструктор с одним параметром для поля mapperUtil
public class FloatDataMapper implements IMapper<FloatData, FloatDataDto> { // Реализация интерфейса IMapper для FloatData и FloatDataDto

    private final MapperUtil mapperUtil; // Поле для хранения экземпляра MapperUtil, внедряется через конструктор

    /**
     * Преобразует FloatData в FloatDataDto.
     * @param floatData Встраиваемый объект FloatData
     * @return FloatDataDto DTO
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса
    public FloatDataDto toDto(FloatData floatData) { // Реализация метода преобразования в DTO
        return mapperUtil.getMapper().map(floatData, FloatDataDto.class); // Использование ModelMapper для преобразования floatData в FloatDataDto
    }

    /**
     * Преобразует FloatDataDto в FloatData.
     * @param floatDataDto DTO FloatDataDto
     * @return FloatData Встраиваемый объект
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса
    public FloatData toEntity(FloatDataDto floatDataDto) { // Реализация метода преобразования во встраиваемый объект
        return mapperUtil.getMapper().map(floatDataDto, FloatData.class); // Использование ModelMapper для преобразования floatDataDto в FloatData
    }
}