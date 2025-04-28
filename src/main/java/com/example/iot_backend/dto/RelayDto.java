package com.example.iot_backend.dto;

import lombok.*; // Импорт аннотаций Lombok
import java.util.List; // Импорт интерфейса List

@EqualsAndHashCode // Генерирует методы equals и hashCode
@NoArgsConstructor // Генерирует конструктор без аргументов
@AllArgsConstructor // Генерирует конструктор со всеми полями
@Getter // Генерирует геттеры
@Setter // Генерирует сеттеры
@ToString // Генерирует метод toString
public class RelayDto {
    // Уникальный идентификатор реле
    private Long id;

    // Список последних значений состояния реле (используем BitDataDto)
    // Примечание: В реальном API может потребоваться пагинация или ограничение количества возвращаемых значений
    private List<BitDataDto> relayValues;

    // Поле isRemoved обычно не включается в DTO для чтения
}