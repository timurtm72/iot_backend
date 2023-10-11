package com.example.iot_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="rooms")
@SQLDelete(sql = "UPDATE rooms SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class Room extends AbstractEntity{
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinColumn(name="sensors_id")
    List<Sensor> sensors;
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinColumn(name="devices_id")
    List<Device> devices;
}
