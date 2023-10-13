package com.example.iot_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "float_type_fields")
@SQLDelete(sql = "UPDATE float_type_fields SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class FloatTypeField extends AbstractEntity{
    @ElementCollection
    @CollectionTable(name = "float_map_entries", joinColumns = @JoinColumn(name = "float_map_id"))
    @MapKeyColumn(name = "float_key")
    @Column(name = "float_value")
    private Map<LocalDateTime, Float> floatValue;
}
