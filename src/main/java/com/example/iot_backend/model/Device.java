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
@Table(name = "devices")
@SQLDelete(sql = "UPDATE devices SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class Device extends AbstractEntity {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "float_type_device_fields_id")
    List<FloatTypeField> floatTypeDeviceFields;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "long_type_device_fields_id")
    List<LongTypeField> longTypeDeviceFields;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bool_type_device_fields_id")
    List<BoolTypeField> boolTypeDeviceFields;
}