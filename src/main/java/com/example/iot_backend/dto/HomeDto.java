package com.example.iot_backend.dto; // Пакет для DTO

import lombok.AllArgsConstructor; // Аннотация Lombok для генерации конструктора со всеми аргументами
import lombok.Data; // Аннотация Lombok: объединяет @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
import lombok.NoArgsConstructor; // Аннотация Lombok для генерации конструктора без аргументов

import java.time.LocalDateTime; // Импорт класса для работы с датой и временем
import java.util.List; // Импорт интерфейса List
import java.util.ArrayList; // Импорт класса ArrayList

/**
 * DTO для сущности Home.
 * Используется для передачи данных о доме, включая список комнат.
 */
@Data // Генерирует геттеры, сеттеры, equals, hashCode, toString
@NoArgsConstructor // Генерирует конструктор без аргументов
@AllArgsConstructor // Генерирует конструктор со всеми аргументами
public class HomeDto {
    /**
     * Уникальный идентификатор дома.
     */
    private Long id; // Поле для хранения идентификатора

    /**
     * Название дома.
     */
    private String name; // Поле для хранения названия

    /**
     * Адрес дома.
     */
    private String address; // Поле для хранения адреса

    /**
     * Идентификатор пользователя-владельца дома.
     */
    private Long ownerId; // Поле для хранения ID владельца

    /**
     * Дата и время создания дома.
     */
    private LocalDateTime createdAt; // Поле для хранения времени создания

    /**
     * Список комнат в этом доме (представленных как DTO).
     */
    private List<RoomDto> rooms = new ArrayList<>(); // Поле для хранения списка DTO комнат
}