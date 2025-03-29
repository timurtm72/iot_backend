package com.example.iot_backend.model.base;

import com.example.iot_backend.model.initial.Relay;
import com.example.iot_backend.model.initial.Switch;
import com.example.iot_backend.model.data.BitData;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

/**
 * Базовый класс для устройств, использующих бинарные данные.
 * Используется как основа для устройств типа включено/выключено.
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "bit_device_base")
@SQLDelete(sql = "UPDATE bit_device_base SET is_removed = true WHERE id=?")
@SQLRestriction("is_removed=false")
public class BitDeviceBase extends DeviceBase {

    /**
     * Коллекция бинарных значений, связанных с устройством
     */
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "bit_values", joinColumns = @JoinColumn(name = "bit_values_id"))
    private List<BitData> bitValues;

    /**
     * Связь с переключателем, если устройство подключено к нему
     */
    @ManyToOne
    @JoinColumn(name = "switch_device_id")
    private Switch switchDevice;

    /**
     * Связь с реле, если устройство подключено к нему
     */
    @ManyToOne
    @JoinColumn(name = "relay_device_id")
    private Relay relayDevice;

}
