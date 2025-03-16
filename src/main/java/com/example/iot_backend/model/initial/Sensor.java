package com.example.iot_backend.model.initial;

import com.example.iot_backend.model.base.AbstractEntity;
import com.example.iot_backend.model.data.FloatData;
import com.example.iot_backend.model.object.Room;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sensor_device")
@SQLDelete(sql = "UPDATE sensor_device SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
        name = "sensor_values",
        joinColumns = @JoinColumn(name = "sensor_device_id")
    )
    private List<FloatData> sensorValues;
}
