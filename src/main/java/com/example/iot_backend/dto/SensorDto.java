package com.example.iot_backend.dto;

import lombok.*; // Импорт аннотаций Lombok
import java.util.List; // Импорт интерфейса List

@EqualsAndHashCode // Генерирует методы equals и hashCode
@NoArgsConstructor // Генерирует конструктор без аргументов
@AllArgsConstructor // Генерирует конструктор со всеми полями
@Getter // Генерирует геттеры
@Setter // Генерирует сеттеры
@ToString // Генерирует метод toString
public class SensorDto {
    // Уникальный идентификатор сенсора
    private Long id;

    // Список последних значений сенсора (используем FloatDataDto)
    private List<FloatDataDto> sensorValues;

    // Поле isRemoved обычно не включается в DTO для чтения
}