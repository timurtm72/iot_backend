package com.example.iot_backend.mapper; // Пакет для мапперов

import com.example.iot_backend.dto.UserReadDto; // Импорт UserReadDto
import com.example.iot_backend.model.object.User; // Импорт сущности User (убедитесь, что путь правильный)
import com.example.iot_backend.utils.MapperUtil; // Импорт утилиты MapperUtil
import lombok.RequiredArgsConstructor; // Импорт аннотации Lombok для генерации конструктора для final полей
import org.springframework.stereotype.Component; // Импорт аннотации Component для регистрации бина в Spring

/**
 * Маппер для преобразования между сущностью User и UserReadDto (без пароля).
 */
@Component // Указывает, что этот класс является компонентом Spring и должен быть управляем контейнером
@RequiredArgsConstructor // Генерирует конструктор с одним параметром для поля mapperUtil
public class UserReadMapper implements IMapper<User, UserReadDto> { // Реализация интерфейса IMapper для User и UserReadDto

    private final MapperUtil mapperUtil; // Поле для хранения экземпляра MapperUtil, внедряется через конструктор

    /**
     * Преобразует сущность User в UserReadDto.
     * @param user Сущность User
     * @return UserReadDto DTO для чтения
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса
    public UserReadDto toDto(User user) { // Реализация метода преобразования в DTO
        return mapperUtil.getMapper().map(user, UserReadDto.class); // Использование ModelMapper для преобразования user в UserReadDto
    }

    /**
     * Преобразует UserReadDto в сущность User.
     * ВНИМАНИЕ: Этот метод может быть не нужен или требовать особой логики,
     * так как UserReadDto не содержит всех полей User (например, пароля).
     * @param userReadDto DTO UserReadDto
     * @return User Сущность (возможно, не полностью заполненная)
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса
    public User toEntity(UserReadDto userReadDto) { // Реализация метода преобразования в сущность
        // ModelMapper может создать User, но поля, отсутствующие в DTO (пароль), будут null
        return mapperUtil.getMapper().map(userReadDto, User.class); // Использование ModelMapper для преобразования userReadDto в User
    }
}