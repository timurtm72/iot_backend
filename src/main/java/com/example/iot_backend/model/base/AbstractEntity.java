package com.example.iot_backend.model.base;

import com.example.iot_backend.enums.DeviceType;
import com.example.iot_backend.model.settings.WiFiParameters;
import jakarta.persistence.*;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * Базовый абстрактный класс для всех сущностей системы IoT
 */
@MappedSuperclass
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class AbstractEntity implements Serializable {
    /**
     * Уникальный идентификатор сущности
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;
    
    /**
     * Название сущности
     */
    @Column(name="name",nullable = false)
    private String name;
    
    /**
     * Описание сущности
     */
    @Column(name="description")
    private String description;
    
    /**
     * Дата и время создания сущности
     */
    @Column(name="created_at",nullable = false)
    private LocalDateTime createdAt;
    
    /**
     * Дата и время удаления сущности
     */
    @Column(name="removed_at",nullable = false)
    private LocalDateTime removedAt;
    
    /**
     * Дата и время последнего изменения сущности
     */
    @Column(name="modified_at",nullable = false)
    private LocalDateTime modifiedAt;
    
    /**
     * Тип устройства (определяет категорию)
     */
    @Column(name="device_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;
    
    /**
     * Статус сущности (активно, неактивно и т.д.)
     */
    @Column(name="status",nullable = false)
    private String status;
    
    /**
     * Версия прошивки устройства
     */
    @Column(name="firmware_version",nullable = false)
    private int firmwareVersion;
    
    /**
     * Производитель устройства
     */
    @Column(name = "manufacturer")
    private String manufacturer;
    
    /**
     * Модель устройства
     */
    @Column(name = "model")
    private String model;
    
    /**
     * Параметры WiFi подключения
     */
    @Embedded
    WiFiParameters wiFiParameters;

    /**
     * Флаг удаления (для мягкого удаления записей)
     */
    @Column(name = "is_removed", nullable = false)
    private boolean isRemoved = Boolean.FALSE;

    /**
     * Метод, вызываемый перед сохранением сущности
     * Устанавливает дату и время создания
     */
    @PrePersist
    public void toCreate() {
        this.createdAt = LocalDateTime.now();
    }

    /**
     * Метод, вызываемый перед обновлением сущности
     * Устанавливает дату и время изменения
     */
    @PreUpdate
    public void toModified() {
        this.modifiedAt = LocalDateTime.now();
    }

    /**
     * Метод, вызываемый перед удалением сущности
     * Устанавливает дату и время удаления
     */
    @PreRemove
    public void toRemove() {
        this.removedAt = LocalDateTime.now();
    }

}
