package com.example.iot_backend.model.device;

import com.example.iot_backend.model.base.FloatDeviceBase;
import com.example.iot_backend.model.initial.Sensor;
import com.example.iot_backend.model.object.Room;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

/**
 * Устройство для сбора данных с датчиков, использующее данные с плавающей точкой.
 * Используется для работы с аналоговыми входами (датчиками).
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sensor_device")
@SQLDelete(sql = "UPDATE sensor_device SET is_removed = true WHERE id = ?")
@SQLRestriction("is_removed=false")
public class SensorDevice extends FloatDeviceBase {
    
    /**
     * Комната, в которой размещено устройство
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
    
    /**
     * Датчики (аналоговые входы), связанные с этим устройством
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "sensor_device_id")
    private List<Sensor> sensors;
} 