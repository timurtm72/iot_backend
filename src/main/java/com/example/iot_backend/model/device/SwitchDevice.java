package com.example.iot_backend.model.device;

import com.example.iot_backend.model.initial.Switch;
import com.example.iot_backend.model.object.Room;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

/**
 * Устройство управления переключателями, использующее бинарные данные (включено/выключено).
 * Используется для работы с цифровыми входами (переключателями).
 */
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "switch_device")
@SQLDelete(sql = "UPDATE switch_device SET is_removed = true WHERE id = ?")
@SQLRestriction("is_removed=false")
public class SwitchDevice {
    
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
    
    /**
     * Комната, в которой размещено устройство
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
    
    /**
     * Переключатели (цифровые входы), связанные с этим устройством
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "switch_device_id")
    private List<Switch> switches;
} 