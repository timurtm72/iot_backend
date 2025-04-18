package com.example.iot_backend.model.device;

import com.example.iot_backend.model.base.DeviceBase;
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
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "relay_device")
@SQLDelete(sql = "UPDATE relay_device SET is_removed = true WHERE id = ?")
@SQLRestriction("is_removed=false")
public class RelayDevice extends DeviceBase {
    
      
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