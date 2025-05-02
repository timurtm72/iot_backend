package com.example.iot_backend.mapper; // Объявляем пакет, в котором находится этот интерфейс маппера.

import com.example.iot_backend.dto.RelayDto; // Импортируем класс RelayDto (DTO).
import com.example.iot_backend.model.initial.Relay; // Импортируем класс Relay (сущность).
import org.mapstruct.Mapper; // Импортируем аннотацию @Mapper из MapStruct.
import org.mapstruct.Mapping; // Импортируем аннотацию @Mapping из MapStruct для настройки маппинга.
import org.mapstruct.MappingConstants; // Импортируем константы MapStruct.

/**
 * Маппер для преобразования между сущностью Relay и RelayDto. // JavaDoc, описывающий маппер.
 */
// Аннотация MapStruct: указывает, что это интерфейс маппера, генерирующий Spring компонент.
// `uses = {BitDataMapper.class}` говорит MapStruct использовать BitDataMapper для маппинга полей типа BitData/BitDataDto (в данном случае, для списка relayValues).
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {BitDataMapper.class})
public interface RelayMapper { // Объявляем публичный интерфейс RelayMapper.
    // Маппинг id и relayValues происходит автоматически с использованием BitDataMapper // Комментарий описывает автоматический маппинг.
    RelayDto toDto(Relay entity); // Абстрактный метод. MapStruct сгенерирует реализацию. Он смапит `id` и использует `BitDataMapper` для преобразования `List<BitData> relayValues` в `List<BitDataDto> relayValues`.

    // Игнорируем isRemoved при маппинге из DTO // Комментарий поясняет назначение @Mapping.
    @Mapping(target = "removed", ignore = true) // Аннотация MapStruct: указывает игнорировать поле 'isRemoved' в цели (Relay) при маппинге из DTO.
    Relay toEntity(RelayDto dto); // Абстрактный метод. MapStruct сгенерирует реализацию. Он смапит `id`, использует `BitDataMapper` для списка `relayValues` и проигнорирует `isRemoved`.
}