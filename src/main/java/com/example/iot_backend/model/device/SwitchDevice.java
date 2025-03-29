package com.example.iot_backend.model.device;

import com.example.iot_backend.model.base.BitDeviceBase;
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
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "switch_device")
@SQLDelete(sql = "UPDATE switch_device SET is_removed = true WHERE id = ?")
@SQLRestriction("is_removed=false")
public class SwitchDevice extends BitDeviceBase {
    
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