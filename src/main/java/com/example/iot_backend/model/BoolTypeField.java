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
@Table(name = "bool_type_fields")
@SQLDelete(sql = "UPDATE bool_type_fields SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class BoolTypeField extends AbstractEntity{
    @ElementCollection
    @CollectionTable(name = "bool_map_entries", joinColumns = @JoinColumn(name = "bool_map_id"))
    @MapKeyColumn(name = "bool_key")
    @Column(name = "bool_value")
    private Map<LocalDateTime,Boolean> boolValue;
}
