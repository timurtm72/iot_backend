package com.example.iot_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="fields")
@SQLDelete(sql = "UPDATE fields SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class Field extends AbstractEntity{
    @Column(name = "float_value")
    private float floatValue;
    @Column(name = "long_value")
    private long longValue;
    @Column(name = "bool_value")
    private boolean boolValue;
}
