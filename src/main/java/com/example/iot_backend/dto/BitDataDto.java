package com.example.iot_backend.dto; // Объявление пакета для класса DTO

import com.fasterxml.jackson.annotation.JsonFormat; // Импорт аннотации для форматирования даты/времени при сериализации в JSON
import lombok.*; // Импорт всех необходимых аннотаций Lombok для сокращения шаблонного кода
import java.time.LocalDateTime; // Импорт класса для представления даты и времени без часового пояса

/**
 * Data Transfer Object (DTO) для встраиваемого класса BitData.
 * Используется для передачи данных о бинарном значении (true/false) и временной метке.
 * Соответствует @Embeddable классу BitData.
 */
@EqualsAndHashCode // Автоматически генерирует методы equals и hashCode на основе полей класса
@NoArgsConstructor // Автоматически генерирует конструктор без аргументов
@AllArgsConstructor // Автоматически генерирует конструктор со всеми полями класса в качестве аргументов
@Getter // Автоматически генерирует геттер-методы для всех полей
@Setter // Автоматически генерирует сеттер-методы для всех полей
@ToString // Автоматически генерирует метод toString для удобного логирования и отладки
public class BitDataDto {

    /**
     * Бинарное значение (истина или ложь).
     */
    private Boolean value; // Поле для хранения булева значения

    /**
     * Временная метка, когда было зафиксировано значение.
     * Форматируется в строку "гггг-ММ-дд ЧЧ:мм:сс" при сериализации в JSON.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") // Указывает формат сериализации даты и времени в JSON
    private LocalDateTime timestamp; // Поле для хранения временной метки
}