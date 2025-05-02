package com.example.iot_backend.mapper; // Объявляем пакет, в котором находится этот интерфейс маппера.

import com.example.iot_backend.dto.LocationDto; // Импортируем класс LocationDto, который будет использоваться как объект передачи данных (Data Transfer Object).
import com.example.iot_backend.model.object.Location; // Импортируем класс Location, который является встраиваемой сущностью (Embeddable).
import org.mapstruct.Mapper; // Импортируем аннотацию @Mapper из библиотеки MapStruct.
import org.mapstruct.MappingConstants; // Импортируем константы MapStruct, включая ComponentModel.

/**
 * Маппер для преобразования между встраиваемым классом Location и LocationDto. // JavaDoc комментарий, описывающий назначение интерфейса.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING) // Аннотация MapStruct: указывает, что это интерфейс маппера. `componentModel = "spring"` говорит MapStruct сгенерировать реализацию этого маппера как Spring компонент (@Component).
public interface LocationMapper extends IMapper<Location, LocationDto> { // Объявляем публичный интерфейс LocationMapper. Он наследует IMapper (если он используется) для базовых методов.

    /**
     * Преобразует Location в LocationDto. // JavaDoc для метода toDto.
     * @param entity Встраиваемый объект Location // Описываем входной параметр - сущность Location.
     * @return LocationDto DTO // Описываем возвращаемое значение - DTO LocationDto.
     */
    @Override // Аннотация показывает, что этот метод переопределяет метод из родительского интерфейса (IMapper). Если IMapper не используется, эту аннотацию можно убрать.
    LocationDto toDto(Location entity); // Абстрактный метод. MapStruct автоматически сгенерирует его реализацию для копирования полей из Location в LocationDto.

    /**
     * Преобразует LocationDto в Location. // JavaDoc для метода toEntity.
     * @param dto DTO LocationDto // Описываем входной параметр - DTO LocationDto.
     * @return Location Встраиваемый объект // Описываем возвращаемое значение - сущность Location.
     */
    @Override // Аннотация показывает, что этот метод переопределяет метод из родительского интерфейса (IMapper). Если IMapper не используется, эту аннотацию можно убрать.
    Location toEntity(LocationDto dto); // Абстрактный метод. MapStruct автоматически сгенерирует его реализацию для копирования полей из LocationDto в Location.
}