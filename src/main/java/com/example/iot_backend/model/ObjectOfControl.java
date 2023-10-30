package com.example.iot_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "objects_of_control")
@SQLDelete(sql = "UPDATE objects_of_control SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class ObjectOfControl extends AbstractEntity {
    @Column(name = "location_country")
    private String locationCountry;
    @Column(name = "location_address")
    private String locationAddress;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "objects_of_control_id")
    private List<User> users;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rooms_id")
    private List<Room> rooms;
}
