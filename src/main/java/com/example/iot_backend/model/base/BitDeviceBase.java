package com.example.iot_backend.model.base;

import com.example.iot_backend.model.initial.Relay;
import com.example.iot_backend.model.initial.Switch;
import com.example.iot_backend.model.data.BitData;
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
    private List<BitData> bitValues;

    @ManyToOne
    @JoinColumn(name = "switch_device_id")
    private Switch switchDevice;

    @ManyToOne
    @JoinColumn(name = "relay_device_id")
    private Relay relayDevice;

}
