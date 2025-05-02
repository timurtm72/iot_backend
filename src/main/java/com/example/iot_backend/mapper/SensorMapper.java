package com.example.iot_backend.mapper; // Объявляем пакет, в котором находится этот интерфейс маппера.

import com.example.iot_backend.dto.SensorDto; // Импортируем класс SensorDto (DTO).
import com.example.iot_backend.model.initial.Sensor; // Импортируем класс Sensor (сущность).
import org.mapstruct.Mapper; // Импортируем аннотацию @Mapper из MapStruct.
import org.mapstruct.Mapping; // Импортируем аннотацию @Mapping из MapStruct для настройки маппинга.
import org.mapstruct.MappingConstants; // Импортируем константы MapStruct.

/**
 * Маппер для преобразования между сущностью Sensor и SensorDto. // JavaDoc, описывающий маппер.
 */
// Аннотация MapStruct: указывает, что это интерфейс маппера, генерирующий Spring компонент.
// `uses = {FloatDataMapper.class}` говорит MapStruct использовать FloatDataMapper для маппинга полей типа FloatData/FloatDataDto (в данном случае, для списка sensorValues).
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {FloatDataMapper.class})
public interface SensorMapper { // Объявляем публичный интерфейс SensorMapper.
    // Маппинг id и sensorValues происходит автоматически с использованием FloatDataMapper // Комментарий описывает автоматический маппинг.
    SensorDto toDto(Sensor entity); // Абстрактный метод. MapStruct сгенерирует реализацию. Он смапит `id` и использует `FloatDataMapper` для преобразования `List<FloatData> sensorValues` в `List<FloatDataDto> sensorValues`.

    // Игнорируем isRemoved при маппинге из DTO // Комментарий поясняет назначение @Mapping.
    @Mapping(target = "removed", ignore = true) // Аннотация MapStruct: указывает игнорировать поле 'isRemoved' в цели (Sensor) при маппинге из DTO.
    Sensor toEntity(SensorDto dto); // Абстрактный метод. MapStruct сгенерирует реализацию. Он смапит `id`, использует `FloatDataMapper` для списка `sensorValues` и проигнорирует `isRemoved`.
}