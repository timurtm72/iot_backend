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
@Table(name = "alarm_device")
@SQLDelete(sql = "UPDATE relay SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class AlarmDevice extends AbstractEntity {
    @ElementCollection(targetClass = BitDeviceBase.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "alarm_values", joinColumns = @JoinColumn(name = "alarm_value_id"))
    @Column(name = "alarm_value", nullable = false)
    private List<BitDeviceBase> alarms;

    @ManyToOne
    @JoinColumn(name = "regulator_device_id")
    private RegulatorDevice regulatorDevice;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}