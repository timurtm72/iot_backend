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
@Table(name = "devices")
@SQLDelete(sql = "UPDATE devices SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class Device extends AbstractEntity {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "floatTypeDeviceFields_id")
    List<FloatTypeField> floatTypeDeviceFields;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "longTypeDeviceFields_id")
    List<LongTypeField> longTypeDeviceFields;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "boolTypeDeviceFields_id")
    List<BoolTypeField> boolTypeDeviceFields;
}