package com.example.iot_backend.mapper;

import com.example.iot_backend.dto.HomeDto;
import com.example.iot_backend.model.object.Home;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {RoomMapper.class, LocationMapper.class})
public interface HomeMapper {

    // Entity -> DTO
    // Мапятся: id, name, createdAt (из AbstractEntity), rooms (через RoomMapper)
    // Мапим location.address -> address
    // Игнорируем ownerId (неясно, как мапить из List<User>)
    @Mapping(source = "location.address", target = "address")
    @Mapping(target = "ownerId", ignore = true) // Игнорируем ownerId
    HomeDto toDto(Home entity);

    // DTO -> Entity
    // Мапятся: name (в AbstractEntity), rooms (через RoomMapper)
    // Мапим address -> location.address
    // Игнорируем ID, ownerId/users, createdAt и другие поля AbstractEntity
    @Mapping(source = "address", target = "location.address")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "location.country", ignore = true) // Игнорируем остальные поля Location,
    @Mapping(target = "location.city", ignore = true)    // если они не пришли в DTO
    @Mapping(target = "users", ignore = true) // Связь с users управляется в сервисе
    @Mapping(target = "description", ignore = true) // Нет в DTO
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "removed", ignore = true)
    @Mapping(target = "removedAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "deviceType", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "firmwareVersion", ignore = true)
    @Mapping(target = "manufacturer", ignore = true)
    @Mapping(target = "model", ignore = true)
    @Mapping(target = "wiFiParameters", ignore = true)
    Home toEntity(HomeDto dto);

    // Метод обновления существующей сущности Home из HomeDto
    @Mapping(source = "address", target = "location.address")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "location.country", ignore = true)
    @Mapping(target = "location.city", ignore = true)
    @Mapping(target = "users", ignore = true)
    @Mapping(target = "description", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "removed", ignore = true)
    @Mapping(target = "removedAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "deviceType", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "firmwareVersion", ignore = true)
    @Mapping(target = "manufacturer", ignore = true)
    @Mapping(target = "model", ignore = true)
    @Mapping(target = "wiFiParameters", ignore = true)
    // @Mapping(target = "rooms", ignore = true) // Обновление комнат - отдельная логика?
    // Если нужно обновлять комнаты через HomeDto, убрать ignore=true для rooms
    // и убедиться, что RoomMapper умеет обновлять (@MappingTarget)
    void updateFromDto(HomeDto dto, @MappingTarget Home entity);
}