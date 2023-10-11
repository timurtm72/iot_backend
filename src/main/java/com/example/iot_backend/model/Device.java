package com.example.iot_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Data
@Entity
@Table(name="device")
@SQLDelete(sql = "UPDATE device SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class Device extends AbstractEntity {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "field_id")
    List<Field> fields;
}