package com.example.iot_backend.mapper; // Пакет для мапперов

import com.example.iot_backend.dto.UserDto; // Импорт UserDto
import com.example.iot_backend.model.object.User; // Импорт сущности User (убедитесь, что путь правильный)
import com.example.iot_backend.utils.MapperUtil; // Импорт утилиты MapperUtil
import lombok.RequiredArgsConstructor; // Импорт аннотации Lombok для генерации конструктора для final полей
import org.springframework.stereotype.Component; // Импорт аннотации Component для регистрации бина в Spring

/**
 * Маппер для преобразования между сущностью User и UserDto.
 */
@Component // Указывает, что этот класс является компонентом Spring и должен быть управляем контейнером
@RequiredArgsConstructor // Генерирует конструктор с одним параметром для поля mapperUtil
public class UserMapper implements IMapper<User, UserDto> { // Реализация интерфейса IMapper для User и UserDto

    private final MapperUtil mapperUtil; // Поле для хранения экземпляра MapperUtil, внедряется через конструктор

    /**
     * Преобразует сущность User в UserDto.
     * @param user Сущность User
     * @return UserDto DTO
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса
    public UserDto toDto(User user) { // Реализация метода преобразования в DTO
        return mapperUtil.getMapper().map(user, UserDto.class); // Использование ModelMapper для преобразования user в UserDto
    }

    /**
     * Преобразует UserDto в сущность User.
     * @param userDto DTO UserDto
     * @return User Сущность
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса
    public User toEntity(UserDto userDto) { // Реализация метода преобразования в сущность
        return mapperUtil.getMapper().map(userDto, User.class); // Использование ModelMapper для преобразования userDto в User
    }
}
