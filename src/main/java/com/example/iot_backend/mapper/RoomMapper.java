package com.example.iot_backend.mapper; // Пакет для мапперов

import com.example.iot_backend.dto.RoomDto; // Импорт DTO для комнаты
import com.example.iot_backend.model.object.Room; // Импорт сущности Room (предполагаемый путь, исправьте при необходимости)
import com.example.iot_backend.utils.MapperUtil; // Импорт утилиты MapperUtil
import com.example.iot_backend.mapper.IMapper; // Импорт базового интерфейса маппера
import lombok.RequiredArgsConstructor; // Импорт аннотации Lombok для генерации конструктора для final полей
import org.springframework.stereotype.Component; // Импорт аннотации Component для регистрации бина в Spring

/**
 * Маппер для преобразования между сущностью Room и RoomDto.
 */
@Component // Указывает, что этот класс является компонентом Spring и должен быть управляем контейнером
@RequiredArgsConstructor // Генерирует конструктор с одним параметром для поля mapperUtil (для final полей)
public class RoomMapper implements IMapper<Room, RoomDto> { // Реализация интерфейса IMapper для Room и RoomDto

    private final MapperUtil mapperUtil; // Поле для хранения экземпляра MapperUtil, внедряется через конструктор

    /**
     * Преобразует сущность Room в RoomDto.
     * @param room Сущность Room
     * @return RoomDto DTO
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса IMapper
    public RoomDto toDto(Room room) { // Реализация метода преобразования сущности в DTO
        // Использует ModelMapper из MapperUtil для копирования данных из сущности в новый объект DTO
        return mapperUtil.getMapper().map(room, RoomDto.class); // Возвращает созданный DTO
    }

    /**
     * Преобразует RoomDto в сущность Room.
     * @param roomDto DTO RoomDto
     * @return Room Сущность
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса IMapper
    public Room toEntity(RoomDto roomDto) { // Реализация метода преобразования DTO в сущность
        // Использует ModelMapper из MapperUtil для копирования данных из DTO в новый объект сущности
        return mapperUtil.getMapper().map(roomDto, Room.class); // Возвращает созданную сущность
    }
}