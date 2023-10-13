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
@Table(name = "long_type_fields")
@SQLDelete(sql = "UPDATE long_type_fields SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class LongTypeField extends AbstractEntity{
    @ElementCollection
    @CollectionTable(name = "long_map_entries", joinColumns = @JoinColumn(name = "long_map_id"))
    @MapKeyColumn(name = "long_key")
    @Column(name = "long_value")
    private Map<LocalDateTime,Long> longValue;
}
