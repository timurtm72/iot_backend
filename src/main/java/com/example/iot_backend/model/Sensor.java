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
@Table(name = "sensors")
@SQLDelete(sql = "UPDATE sensors SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class Sensor extends AbstractEntity {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "floatTypeSensorFields_id")
    List<FloatTypeField> floatTypeSensorFields;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "longTypeSensorFields_id")
    List<LongTypeField> longTypeSensorFields;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "boolTypeSensorFields_id")
    List<BoolTypeField> boolTypeSensorFields;
}
