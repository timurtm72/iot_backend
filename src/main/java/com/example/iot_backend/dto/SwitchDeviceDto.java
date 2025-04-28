package com.example.iot_backend.dto;

import com.example.iot_backend.enums.InOutType; // Импорт перечисления InOutType
import com.fasterxml.jackson.annotation.JsonFormat; // Импорт для форматирования даты/времени
import lombok.*; // Импорт аннотаций Lombok
import java.time.LocalDateTime; // Импорт класса LocalDateTime
import java.util.List; // Импорт интерфейса List

@EqualsAndHashCode // Генерирует методы equals и hashCode
@NoArgsConstructor // Генерирует конструктор без аргументов
@AllArgsConstructor // Генерирует конструктор со всеми полями
@Getter // Генерирует геттеры
@Setter // Генерирует сеттеры
@ToString // Генерирует метод toString
public class SwitchDeviceDto {
    // Идентификатор устройства
    private Long id;

    // Название устройства (из AbstractEntity)
    private String name;

    // Описание устройства (из AbstractEntity)
    private String description;

    // Тип устройства (вход/выход) (из DeviceBase)
    private InOutType inOutType;

    // Название значения (из DeviceBase)
    private String valueName;

    // Идентификатор комнаты, где находится устройство
    private Long roomId;

    // Список идентификаторов связанных переключателей (Switch)
    private List<Long> switchIds;

    // Дата создания (из AbstractEntity)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    // Дата изменения (из AbstractEntity)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedAt;

    // Поля isRemoved и removedAt обычно не включаются в DTO для чтения
}