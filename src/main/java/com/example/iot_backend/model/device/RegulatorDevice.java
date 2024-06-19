package com.example.iot_backend.model.device;

import com.example.iot_backend.model.base.RegulatorDeviceBase;
import com.example.iot_backend.model.object.ErrorDeviceData;
import com.example.iot_backend.model.object.FloatDeviceData;
import com.example.iot_backend.model.object.Room;
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
@Table(name = "regulator_device")
@SQLDelete(sql = "UPDATE relay SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class RegulatorDevice extends RegulatorDeviceBase {
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @OneToMany(mappedBy = "regulatorDevice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RelaySection> relaySection;
    @OneToMany(mappedBy = "regulatorDevice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SensorSection> sensorsSection;
    @OneToMany(mappedBy = "regulatorDevice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SwitchSection> switchSection;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "reg_errors", joinColumns = @JoinColumn(name = "reg_error_id"))
    private List<ErrorDeviceData> regErrors;
}
