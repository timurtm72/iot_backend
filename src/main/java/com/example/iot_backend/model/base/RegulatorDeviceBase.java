package com.example.iot_backend.model.base;

import com.example.iot_backend.enums.RegMode;
import jakarta.persistence.*;
import lombok.*;

/**
 * Базовый класс для регуляторов.
 * Содержит общие свойства всех устройств регулирования.
 */
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public abstract class RegulatorDeviceBase extends AbstractEntity {
    /**
     * Режим регулирования
     */
    @Column(name = "reg_mode")
    @Enumerated(EnumType.STRING)
    private RegMode regMode;

    /**
     * Установленное значение для регулирования
     */
    @Column(name = "set_value", nullable = false)
    private Float value;

    /**
     * Название регулируемой величины
     */
    @Column(name = "value_name", nullable = false)
    private String valueName;

    /**
     * Нижний гистерезис
     */
    @Column(name = "low_hysteresis", nullable = false)
    private Float lowHysteresis;

    /**
     * Верхний гистерезис
     */
    @Column(name = "high_hysteresis", nullable = false)
    private Float highHysteresis;

    /**
     * Описание устройства регулирования
     */
    @Column(name = "description", nullable = false)
    private String description;
}
