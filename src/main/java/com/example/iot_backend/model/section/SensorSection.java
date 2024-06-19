package com.example.iot_backend.model.section;

import com.example.iot_backend.model.base.FloatDeviceBase;
import com.example.iot_backend.model.device.RegulatorDevice;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sensor_section")
@SQLDelete(sql = "UPDATE relay SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class SensorSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;
    @OneToMany(mappedBy = "sensorSection", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FloatDeviceBase> sensorSection;
    @ManyToOne
    @JoinColumn(name = "regulator_device_id")
    private RegulatorDevice regulatorDevice;
}