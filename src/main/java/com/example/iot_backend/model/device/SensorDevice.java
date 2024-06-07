package com.example.iot_backend.model.device;


import com.example.iot_backend.model.Base.FloatDeviceBase;
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
@Table(name = "sensor_device")
@SQLDelete(sql = "UPDATE relay SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class SensorDevice extends AbstractEntity {
    @OneToMany(mappedBy = "sensorDevice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FloatDeviceBase> sensors;

    @ManyToOne
    @JoinColumn(name = "regulator_device_id")
    private RegulatorDevice regulatorDevice;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
