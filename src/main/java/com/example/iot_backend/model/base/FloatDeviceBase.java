package com.example.iot_backend.model.base;

import com.example.iot_backend.model.device.SensorDevice;
import com.example.iot_backend.model.object.ErrorDeviceData;
import com.example.iot_backend.model.object.FloatDeviceData;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "float_device_base")
@SQLDelete(sql = "UPDATE credentials SET is_removed = true WHERE id=?")
@Where(clause = "is_removed=false")
public class FloatDeviceBase extends DeviceBase {
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "float_values", joinColumns = @JoinColumn(name = "float_values_id"))
    private List<FloatDeviceData> floatValues;

    @ManyToOne
    @JoinColumn(name = "sensor_device_id")
    private SensorDevice sensorDevice;
}