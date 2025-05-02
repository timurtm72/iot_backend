package com.example.iot_backend.mapper; // Объявляем пакет, в котором находится этот интерфейс маппера.

import com.example.iot_backend.dto.SwitchDto; // Импортируем класс SwitchDto (DTO).
import com.example.iot_backend.model.initial.Switch; // Импортируем класс Switch (сущность).
import org.mapstruct.Mapper; // Импортируем аннотацию @Mapper из MapStruct.
import org.mapstruct.Mapping; // Импортируем аннотацию @Mapping из MapStruct для настройки маппинга.
import org.mapstruct.MappingConstants; // Импортируем константы MapStruct.

/**
 * Маппер для преобразования между сущностью Switch и SwitchDto. // JavaDoc, описывающий маппер.
 */
// Аннотация MapStruct: указывает, что это интерфейс маппера, генерирующий Spring компонент.
// `uses = {BitDataMapper.class}` говорит MapStruct использовать BitDataMapper для маппинга полей типа BitData/BitDataDto (в данном случае, для списка switchValues).
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {BitDataMapper.class})
public interface SwitchMapper { // Объявляем публичный интерфейс SwitchMapper.
    // Маппинг id и switchValues происходит автоматически с использованием BitDataMapper // Комментарий описывает автоматический маппинг.
    SwitchDto toDto(Switch entity); // Абстрактный метод. MapStruct сгенерирует реализацию. Он смапит `id` и использует `BitDataMapper` для преобразования `List<BitData> switchValues` в `List<BitDataDto> switchValues`.

    // Игнорируем isRemoved при маппинге из DTO // Комментарий поясняет назначение @Mapping.
    @Mapping(target = "removed", ignore = true) // Аннотация MapStruct: указывает игнорировать поле 'isRemoved' в цели (Switch) при маппинге из DTO.
    Switch toEntity(SwitchDto dto); // Абстрактный метод. MapStruct сгенерирует реализацию. Он смапит `id`, использует `BitDataMapper` для списка `switchValues` и проигнорирует `isRemoved`.
}