package com.example.iot_backend.dto;

import com.example.iot_backend.enums.RegMode; // Импорт перечисления RegMode
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
public class RegulatorDeviceDto {
    // Идентификатор устройства
    private Long id;

    // Название устройства (из AbstractEntity)
    private String name;

    // Описание устройства (из RegulatorDeviceBase) - переопределено? Используем его.
    private String description;

    // Режим регулирования (из RegulatorDeviceBase)
    private RegMode regMode;

    // Установленное значение (из RegulatorDeviceBase)
    private Float value;

    // Название регулируемой величины (из RegulatorDeviceBase)
    private String valueName;

    // Нижний гистерезис (из RegulatorDeviceBase)
    private Float lowHysteresis;

    // Верхний гистерезис (из RegulatorDeviceBase)
    private Float highHysteresis;

    // Идентификатор комнаты, где находится устройство
    private Long roomId;

    // Список идентификаторов связанных переключателей (Switch)
    private List<Long> switchIds;

    // Список идентификаторов связанных реле (Relay)
    private List<Long> relayIds;

    // Список идентификаторов связанных сенсоров (Sensor)
    private List<Long> sensorIds;

    // Дата создания (из AbstractEntity)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    // Дата изменения (из AbstractEntity)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedAt;

    // Поля isRemoved и removedAt обычно не включаются в DTO для чтения
}