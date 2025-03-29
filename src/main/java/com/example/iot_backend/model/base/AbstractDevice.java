package com.example.iot_backend.model.base;

import com.example.iot_backend.enums.DeviceType;
import jakarta.persistence.*;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Базовый абстрактный класс для всех устройств системы IoT
 */
@MappedSuperclass
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class AbstractDevice implements Serializable {
    /**
     * Уникальный идентификатор устройства
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;
    
    /**
     * Название устройства
     */
    @Column(name="name",nullable = false)
    private String name;
    
    /**
     * Описание устройства
     */
    @Column(name="description")
    private String description;
    
    /**
     * Дата и время создания устройства
     */
    @Column(name="created_at",nullable = false)
    private LocalDateTime createdAt;
    
    /**
     * Дата и время удаления устройства
     */
    @Column(name="removed_at",nullable = false)
    private LocalDateTime removedAt;
    
    /**
     * Дата и время последнего изменения устройства
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
     * Статус устройства (активно, неактивно и т.д.)
     */
    @Column(name="status",nullable = false)
    private String status;
    
    /**
     * Флаг удаления (для мягкого удаления записей)
     */
    @Column(name = "is_removed", nullable = false)
    private boolean isRemoved = Boolean.FALSE;

    /**
     * Метод, вызываемый перед сохранением устройства
     * Устанавливает дату и время создания
     */
    @PrePersist
    public void toCreate() {
        this.createdAt = LocalDateTime.now();
    }

    /**
     * Метод, вызываемый перед обновлением устройства
     * Устанавливает дату и время изменения
     */
    @PreUpdate
    public void toModified() {
        this.modifiedAt = LocalDateTime.now();
    }

    /**
     * Метод, вызываемый перед удалением устройства
     * Устанавливает дату и время удаления
     */
    @PreRemove
    public void toRemove() {
        this.removedAt = LocalDateTime.now();
    }
}
