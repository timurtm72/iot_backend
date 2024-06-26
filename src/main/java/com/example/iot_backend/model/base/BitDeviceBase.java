package com.example.iot_backend.model.base;

import com.example.iot_backend.model.device.RelayDevice;
import com.example.iot_backend.model.device.SwitchDevice;
import com.example.iot_backend.model.object.BitDeviceData;
import com.example.iot_backend.model.object.ErrorDeviceData;
import com.example.iot_backend.model.object.FloatDeviceData;
import com.example.iot_backend.model.section.RelaySection;
import com.example.iot_backend.model.section.SensorSection;
import com.example.iot_backend.model.section.SwitchSection;
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
@Table(name = "bit_device_base")
@SQLDelete(sql = "UPDATE credentials SET is_removed = true WHERE id=?")
@Where(clause = "is_removed=false")
public class BitDeviceBase extends DeviceBase {

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "bit_values", joinColumns = @JoinColumn(name = "bit_values_id"))
    private List<BitDeviceData> bitValues;

    @ManyToOne
    @JoinColumn(name = "switch_device_id")
    private SwitchDevice switchDevice; // Связь с SwitchDevice

    @ManyToOne
    @JoinColumn(name = "relay_device_id")
    private RelayDevice relayDevice;

    @ManyToOne
    @JoinColumn(name = "relay_section_id")
    private RelaySection relaySection;

    @ManyToOne
    @JoinColumn(name = "switch_section_id")
    private SwitchSection switchSection;
}