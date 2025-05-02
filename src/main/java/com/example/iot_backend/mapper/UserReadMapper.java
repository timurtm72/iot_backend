package com.example.iot_backend.mapper; // Объявляем пакет, в котором находится этот интерфейс маппера.

import com.example.iot_backend.dto.UserReadDto; // Импортируем класс UserReadDto (DTO для чтения данных пользователя).
import com.example.iot_backend.model.object.User; // Импортируем класс User (сущность пользователя).
import org.mapstruct.Mapper; // Импортируем аннотацию @Mapper из MapStruct.
import org.mapstruct.MappingConstants; // Импортируем константы MapStruct.

/**
 * Маппер для преобразования между сущностью User и UserReadDto (без пароля). // JavaDoc, описывающий маппер. Уточняет, что пароль не мапится.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING) // Аннотация MapStruct: указывает, что это интерфейс маппера, генерирующий Spring компонент.
public interface UserReadMapper { // Объявляем публичный интерфейс UserReadMapper.
    // Все поля (id, firstName, lastName, role, email, login) мапятся автоматически // Комментарий поясняет авто-маппинг.
    // Поля password, homes, isRemoved в User игнорируются, так как их нет в UserReadDto // Комментарий поясняет, какие поля сущности игнорируются неявно.
    UserReadDto toDto(User entity); // Абстрактный метод. MapStruct сгенерирует реализацию для копирования полей из User в UserReadDto. Метод `toEntity` не нужен, так как это DTO только для чтения.
}