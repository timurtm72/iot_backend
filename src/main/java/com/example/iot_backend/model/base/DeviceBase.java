package com.example.iot_backend.model.base;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * Базовый абстрактный класс для всех устройств.
 * Содержит общие поля и функциональность для всех типов устройств.
 */
@MappedSuperclass
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class DeviceBase implements Serializable {
    /**
     * Уникальный идентификатор устройства
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Тип устройства (вход/выход)
     */
    @Column(name = "in_out_type", nullable = false)
    private String inOutType;

    /**
     * Название устройства
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Описание устройства
     */
    @Column(name = "description", nullable = false)
    private String description;

    /**
     * Название измеряемой величины
     */
    @Column(name = "value_name", nullable = false)
    private String valueName;
    
    /**
     * Флаг удаления для мягкого удаления записей
     */
    @Column(name = "is_removed", nullable = false)
    private boolean isRemoved = Boolean.FALSE;
}