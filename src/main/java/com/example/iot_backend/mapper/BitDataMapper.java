package com.example.iot_backend.mapper; // Объявляем пакет, в котором находится этот интерфейс маппера.

import com.example.iot_backend.dto.BitDataDto; // Импортируем класс BitDataDto (DTO).
import com.example.iot_backend.model.data.BitData; // Импортируем класс BitData (встраиваемая сущность).
import org.mapstruct.Mapper; // Импортируем аннотацию @Mapper из MapStruct.
import org.mapstruct.MappingConstants; // Импортируем константы MapStruct.

/**
 * Маппер для преобразования между встраиваемым классом BitData и BitDataDto. // JavaDoc, описывающий маппер.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING) // Аннотация MapStruct: указывает, что это интерфейс маппера, генерирующий Spring компонент.
public interface BitDataMapper { // Объявляем публичный интерфейс BitDataMapper.

    /**
     * Преобразует BitData в BitDataDto. // JavaDoc для метода toDto.
     * @param entity Встраиваемый объект BitData // Входной параметр - сущность.
     * @return BitDataDto DTO // Возвращаемое значение - DTO.
     */
    BitDataDto toDto(BitData entity); // Абстрактный метод. MapStruct автоматически сгенерирует реализацию для копирования полей 'value' и 'timestamp'.

    /**
     * Преобразует BitDataDto в BitData. // JavaDoc для метода toEntity.
     * @param dto DTO BitDataDto // Входной параметр - DTO.
     * @return BitData Встраиваемый объект // Возвращаемое значение - сущность.
     */
    BitData toEntity(BitDataDto dto); // Абстрактный метод. MapStruct автоматически сгенерирует реализацию для копирования полей 'value' и 'timestamp'.
}