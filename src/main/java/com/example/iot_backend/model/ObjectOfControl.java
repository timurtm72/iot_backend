package com.example.iot_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.util.List;

@Data
@Entity
@Table(name="object_of_control")
@SQLDelete(sql = "UPDATE object_of_control SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class ObjectOfControl extends AbstractEntity{
    @Column(name = "location_country")
    private String locationCountry;
    @Column(name = "location_address")
    private String locationAddress;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "object_of_control_user",
            joinColumns = { @JoinColumn(name = "object_of_control_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private List<User> users;
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="room_id")
    private List<Room> rooms;
}
