package com.example.iot_backend.model.device;

import com.example.iot_backend.model.base.RegulatorDeviceBase;
import com.example.iot_backend.model.initial.Relay;
import com.example.iot_backend.model.initial.Sensor;
import com.example.iot_backend.model.initial.Switch;
import com.example.iot_backend.model.object.Room;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

/**
 * Устройство регулирования.
 * Используется для управления комплексными системами с датчиками, реле и переключателями.
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "regulator_device")
@SQLDelete(sql = "UPDATE regulator_device SET is_removed = true WHERE id = ?")
@SQLRestriction("is_removed=false")
public class RegulatorDevice extends RegulatorDeviceBase {
    /**
     * Комната, в которой размещено устройство
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    /**
     * Переключатели, связанные с этим регулятором
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "regulator_device_id")
    private List<Switch> switches;

    /**
     * Реле, управляемые этим регулятором
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "regulator_device_id")
    private List<Relay> relays;

    /**
     * Датчики, связанные с этим регулятором
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "regulator_device_id")
    private List<Sensor> sensors; 
}
