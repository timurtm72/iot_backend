package com.example.iot_backend.model.object;


import com.example.iot_backend.model.device.RegulatorDevice;
import com.example.iot_backend.model.device.RelayDevice;
import com.example.iot_backend.model.device.SensorDevice;
import com.example.iot_backend.model.device.SwitchDevice;
import com.example.iot_backend.model.object.AbstractEntity;
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
@Table(name = "room")
@SQLDelete(sql = "UPDATE relay SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class Room extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_id", nullable = false)
    private Home home;
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RelayDevice> roomRelays;
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SensorDevice> roomSensors;
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SwitchDevice> roomSwitches;
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegulatorDevice> regDevices;
}
