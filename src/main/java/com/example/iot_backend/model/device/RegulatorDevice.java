package com.example.iot_backend.model.device;

import com.example.iot_backend.model.base.RegulatorDeviceBase;
import com.example.iot_backend.model.initial.Relay;
import com.example.iot_backend.model.initial.Sensor;
import com.example.iot_backend.model.initial.Switch;
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
@Table(name = "regulator_device")
@SQLDelete(sql = "UPDATE relay SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class RegulatorDevice extends RegulatorDeviceBase {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "regulator_device_id")
    private List<Switch> switches;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "regulator_device_id")
    private List<Relay> relays;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "regulator_device_id")
    private List<Sensor> sensors; 
}
