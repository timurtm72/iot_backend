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
@Table(name = "relay_device")
@SQLDelete(sql = "UPDATE relay SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class RelayDevice extends AbstractEntity {
    @OneToMany(mappedBy = "relayDevice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BitDeviceBase> relays;
    @ManyToOne
    @JoinColumn(name = "regulator_device_id")
    private RegulatorDevice regulatorDevice;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}