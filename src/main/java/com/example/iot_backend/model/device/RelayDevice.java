package com.example.iot_backend.model.device;

import com.example.iot_backend.model.initial.Relay;
import com.example.iot_backend.model.object.Room;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

/**
 * Устройство управления реле, использующее бинарные данные (включено/выключено).
 * Используется для работы с цифровыми выходами.
 */
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "relay_device")
@SQLDelete(sql = "UPDATE relay_device SET is_removed = true WHERE id = ?")
@SQLRestriction("is_removed=false")
public class RelayDevice {
    
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
     * Реле (цифровые выходы), связанные с этим устройством
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "relay_device_id")
    private List<Relay> relays;
} 