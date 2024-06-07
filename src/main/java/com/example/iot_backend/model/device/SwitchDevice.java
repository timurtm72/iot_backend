package com.example.iot_backend.model.device;


import com.example.iot_backend.model.base.BitDeviceBase;
import com.example.iot_backend.model.object.AbstractEntity;
import com.example.iot_backend.model.object.Room;
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
@Table(name = "switch_device")
@SQLDelete(sql = "UPDATE switch SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class SwitchDevice extends AbstractEntity {
    @OneToMany(mappedBy = "switchDevice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BitDeviceBase> switches;

    @ManyToOne
    @JoinColumn(name = "regulator_device_id")
    private RegulatorDevice regulatorDevice;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}