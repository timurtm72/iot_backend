package com.example.iot_backend.mapper; // Объявляем пакет, в котором находится этот интерфейс маппера.

import com.example.iot_backend.dto.UserDto; // Импортируем класс UserDto (DTO для создания/обновления пользователя).
import com.example.iot_backend.model.object.User; // Импортируем класс User (сущность пользователя).
import org.mapstruct.Mapper; // Импортируем аннотацию @Mapper из MapStruct.
import org.mapstruct.Mapping; // Импортируем аннотацию @Mapping из MapStruct для настройки маппинга.
import org.mapstruct.MappingConstants; // Импортируем константы MapStruct.
import org.mapstruct.MappingTarget; // Импортируем аннотацию @MappingTarget для методов обновления.

/**
 * Маппер для преобразования между сущностью User и UserDto. // JavaDoc, описывающий маппер.
 */
// Аннотация MapStruct: указывает, что это интерфейс маппера, генерирующий Spring компонент.
// `uses = {HomeMapper.class}` было бы нужно, если бы мы мапили поле `homes`.
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING /*, uses = {HomeMapper.class} - если бы homes мапились */)
public interface UserMapper { // Объявляем публичный интерфейс UserMapper.

    // Entity -> DTO: // Комментарий к секции маппинга Сущность -> DTO.
    // Мапятся: id, firstName, lastName, role, email, login // Пояснение авто-маппинга.
    // Не мапятся (нет в UserDto): password, homes, isRemoved // Пояснение неявного игнорирования полей.
    UserDto toDto(User entity); // Абстрактный метод. MapStruct сгенерирует реализацию для копирования полей из User в UserDto, игнорируя отсутствующие в DTO.

    // DTO -> Entity: // Комментарий к секции маппинга DTO -> Сущность.
    // Мапятся: firstName, lastName, role, email, login // Пояснение авто-маппинга.
    // Не мапятся (нужно игнорировать): // Пояснение полей, которые будут проигнорированы с помощью @Mapping.
    @Mapping(target = "id", ignore = true) // Игнорируем `id`: он либо null (при создании), либо берется из существующей сущности (при обновлении).
    @Mapping(target = "password", ignore = true) // Игнорируем `password`: хеширование и установка пароля должны происходить в сервисном слое.
    @Mapping(target = "homes", ignore = true) // Игнорируем `homes`: управление связями ManyToMany обычно происходит отдельно.
    @Mapping(target = "removed", ignore = true) // Игнорируем `isRemoved`: этот флаг управляется логикой удаления.
    User toEntity(UserDto dto); // Абстрактный метод. MapStruct сгенерирует реализацию для создания новой сущности User из UserDto, игнорируя указанные поля.

    // Метод для обновления существующей сущности из DTO: // Комментарий к методу обновления.
    // Те же игнорирования, что и в toEntity // Пояснение, что игнорируются те же поля.
    @Mapping(target = "id", ignore = true) // Игнорируем `id`.
    @Mapping(target = "password", ignore = true) // Игнорируем `password`.
    @Mapping(target = "homes", ignore = true) // Игнорируем `homes`.
    @Mapping(target = "removed", ignore = true) // Игнорируем `isRemoved`.
    // Аннотация `@MappingTarget` указывает MapStruct обновлять переданный объект `entity`, а не создавать новый.
    void updateFromDto(UserDto dto, @MappingTarget User entity); // Абстрактный метод. MapStruct сгенерирует реализацию для обновления полей `entity` значениями из `dto`, игнорируя указанные поля.
}
