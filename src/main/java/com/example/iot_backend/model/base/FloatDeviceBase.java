package com.example.iot_backend.model.base;

import com.example.iot_backend.model.initial.Sensor;
import com.example.iot_backend.model.data.FloatData;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

/**
 * Базовый класс для устройств, использующих данные с плавающей точкой.
 * Используется как основа для датчиков и аналоговых устройств.
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "float_device_base")
@SQLDelete(sql = "UPDATE float_device_base SET is_removed = true WHERE id=?")
@SQLRestriction("is_removed=false")
public class FloatDeviceBase extends DeviceBase {
    /**
     * Коллекция значений с плавающей точкой, связанных с устройством
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "float_values", joinColumns = @JoinColumn(name = "float_values_id"))
    private List<FloatData> floatValues;

    /**
     * Связь с датчиком, если устройство подключено к нему
     */
    @ManyToOne
    @JoinColumn(name = "sensor_device_id")
    private Sensor sensorDevice;

}