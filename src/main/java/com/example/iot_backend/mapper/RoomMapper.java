package com.example.iot_backend.mapper; // Объявляем пакет, в котором находится этот интерфейс маппера.

import com.example.iot_backend.dto.RoomDto; // Импортируем класс RoomDto (DTO).
import com.example.iot_backend.model.object.Room; // Импортируем класс Room (сущность).
import org.mapstruct.Mapper; // Импортируем аннотацию @Mapper из MapStruct.
import org.mapstruct.Mapping; // Импортируем аннотацию @Mapping из MapStruct для настройки маппинга.
import org.mapstruct.MappingConstants; // Импортируем константы MapStruct.
import org.mapstruct.MappingTarget; // Импортируем аннотацию @MappingTarget для методов обновления.

/**
 * Маппер для преобразования между сущностью Room и RoomDto. // JavaDoc, описывающий маппер.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING) // Аннотация MapStruct: указывает, что это интерфейс маппера, генерирующий Spring компонент.
public interface RoomMapper { // Объявляем публичный интерфейс RoomMapper.

    // Entity -> DTO // Комментарий к секции маппинга Сущность -> DTO.
    // Мапятся: id, name, description, createdAt (из AbstractEntity) // Пояснение автоматического маппинга полей из Room и его суперкласса AbstractEntity.
    // Мапим home.id -> homeId // Пояснение ручного маппинга для связи с Home.
    @Mapping(source = "home.id", target = "homeId") // Аннотация MapStruct: указывает мапить поле `id` из объекта `home` (в сущности Room) в поле `homeId` (в DTO RoomDto).
    // Остальные поля AbstractEntity (deviceType, status, ...) игнорируются, т.к. их нет в DTO // Пояснение неявного игнорирования остальных полей.
    RoomDto toDto(Room entity); // Абстрактный метод. MapStruct сгенерирует реализацию для копирования полей из Room (и AbstractEntity) в RoomDto согласно настройкам.

    // DTO -> Entity // Комментарий к секции маппинга DTO -> Сущность.
    // Мапятся: name, description (в AbstractEntity). Поле createdAt есть в DTO, но будет проигнорировано ниже.
    // Игнорируем ID, home и другие поля AbstractEntity, которые не должны устанавливаться из DTO // Общее пояснение игнорируемых полей.
    @Mapping(target = "id", ignore = true) // Игнорируем `id`.
    @Mapping(target = "home", ignore = true) // Игнорируем `home`: установка связи ManyToOne должна происходить в сервисе (загрузка Home по homeId из DTO).
    @Mapping(target = "removed", ignore = true) // Игнорируем флаг мягкого удаления.
    @Mapping(target = "removedAt", ignore = true) // Игнорируем дату мягкого удаления.
    @Mapping(target = "modifiedAt", ignore = true) // Игнорируем дату модификации (устанавливается через @PreUpdate).
    @Mapping(target = "createdAt", ignore = true) // Игнорируем дату создания (устанавливается через @PrePersist при создании).
    @Mapping(target = "deviceType", ignore = true) // Игнорируем унаследованное поле deviceType.
    @Mapping(target = "status", ignore = true) // Игнорируем унаследованное поле status.
    @Mapping(target = "firmwareVersion", ignore = true) // Игнорируем унаследованное поле firmwareVersion.
    @Mapping(target = "manufacturer", ignore = true) // Игнорируем унаследованное поле manufacturer.
    @Mapping(target = "model", ignore = true) // Игнорируем унаследованное поле model.
    @Mapping(target = "wiFiParameters", ignore = true) // Игнорируем унаследованное поле wiFiParameters.
    Room toEntity(RoomDto dto); // Абстрактный метод. MapStruct сгенерирует реализацию для создания новой сущности Room из RoomDto, игнорируя указанные поля.

    // Метод для обновления существующей сущности из DTO: // Комментарий к методу обновления.
    @Mapping(target = "id", ignore = true) // Игнорируем `id`.
    @Mapping(target = "home", ignore = true) // Игнорируем `home`.
    @Mapping(target = "removed", ignore = true) // Игнорируем `isRemoved`.
    @Mapping(target = "removedAt", ignore = true) // Игнорируем `removedAt`.
    @Mapping(target = "modifiedAt", ignore = true) // Игнорируем `modifiedAt`.
    @Mapping(target = "createdAt", ignore = true) // Игнорируем `createdAt`.
    @Mapping(target = "deviceType", ignore = true) // Игнорируем `deviceType`.
    @Mapping(target = "status", ignore = true) // Игнорируем `status`.
    @Mapping(target = "firmwareVersion", ignore = true) // Игнорируем `firmwareVersion`.
    @Mapping(target = "manufacturer", ignore = true) // Игнорируем `manufacturer`.
    @Mapping(target = "model", ignore = true) // Игнорируем `model`.
    @Mapping(target = "wiFiParameters", ignore = true) // Игнорируем `wiFiParameters`.
    // Аннотация `@MappingTarget` указывает MapStruct обновлять переданный объект `entity`.
    void updateFromDto(RoomDto dto, @MappingTarget Room entity); // Абстрактный метод. MapStruct сгенерирует реализацию для обновления `entity` из `dto`, игнорируя указанные поля.
}