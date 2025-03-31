package com.example.iot_backend.model.base;

import com.example.iot_backend.enums.InOutType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * Базовый класс для всех устройств
 */
@MappedSuperclass
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class DeviceBase extends AbstractDevice implements Serializable {
    /**
     * Тип устройства (вход/выход)
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "in_out_type", nullable = false)
    private InOutType inOutType;

    /**
     * Название измеряемой величины
     */
    @Column(name = "value_name", nullable = false)
    private String valueName;
}