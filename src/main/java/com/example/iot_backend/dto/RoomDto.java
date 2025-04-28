package com.example.iot_backend.dto; // Пакет для DTO

import lombok.AllArgsConstructor; // Аннотация Lombok для генерации конструктора со всеми аргументами
import lombok.Data; // Аннотация Lombok: объединяет @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
import lombok.NoArgsConstructor; // Аннотация Lombok для генерации конструктора без аргументов

import java.time.LocalDateTime; // Импорт класса для работы с датой и временем
// import java.util.List; // Если нужно передавать список устройств в комнате
// import java.util.ArrayList; // Если нужно передавать список устройств в комнате

/**
 * DTO для сущности Room.
 * Используется для передачи данных о комнате.
 */
@Data // Генерирует геттеры, сеттеры, equals, hashCode, toString
@NoArgsConstructor // Генерирует конструктор без аргументов
@AllArgsConstructor // Генерирует конструктор со всеми аргументами
public class RoomDto {
    /**
     * Уникальный идентификатор комнаты.
     */
    private Long id; // Поле для хранения идентификатора

    /**
     * Название комнаты.
     */
    private String name; // Поле для хранения названия

    /**
     * Описание комнаты.
     */
    private String description; // Поле для хранения описания

    /**
     * Идентификатор дома, к которому принадлежит комната.
     */
    private Long homeId; // Поле для хранения ID дома

    /**
     * Дата и время создания комнаты.
     */
    private LocalDateTime createdAt; // Поле для хранения времени создания

    // Можно добавить список DTO устройств, если это необходимо
    // private List<DeviceDto> devices = new ArrayList<>();
}