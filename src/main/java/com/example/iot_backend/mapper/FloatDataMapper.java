package com.example.iot_backend.mapper; // Объявляем пакет, в котором находится этот интерфейс маппера.

import com.example.iot_backend.dto.FloatDataDto; // Импортируем класс FloatDataDto (DTO).
import com.example.iot_backend.model.data.FloatData; // Импортируем класс FloatData (встраиваемая сущность).
import org.mapstruct.Mapper; // Импортируем аннотацию @Mapper из MapStruct.
import org.mapstruct.MappingConstants; // Импортируем константы MapStruct.

/**
 * Маппер для преобразования между встраиваемым классом FloatData и FloatDataDto. // JavaDoc, описывающий маппер.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING) // Аннотация MapStruct: указывает, что это интерфейс маппера, генерирующий Spring компонент.
public interface FloatDataMapper { // Объявляем публичный интерфейс FloatDataMapper.

    /**
     * Преобразует FloatData в FloatDataDto. // JavaDoc для метода toDto.
     * @param entity Встраиваемый объект FloatData // Входной параметр - сущность.
     * @return FloatDataDto DTO // Возвращаемое значение - DTO.
     */
    FloatDataDto toDto(FloatData entity); // Абстрактный метод. MapStruct автоматически сгенерирует реализацию для копирования полей 'value' и 'timestamp'.

    /**
     * Преобразует FloatDataDto в FloatData. // JavaDoc для метода toEntity.
     * @param dto DTO FloatDataDto // Входной параметр - DTO.
     * @return FloatData Встраиваемый объект // Возвращаемое значение - сущность.
     */
    FloatData toEntity(FloatDataDto dto); // Абстрактный метод. MapStruct автоматически сгенерирует реализацию для копирования полей 'value' и 'timestamp'.
}