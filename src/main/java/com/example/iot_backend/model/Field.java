package com.example.iot_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fields")
@SQLDelete(sql = "UPDATE fields SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class Field extends AbstractEntity {
    @ElementCollection
    @CollectionTable(name = "float_map_entries", joinColumns = @JoinColumn(name = "float_map_id"))
    @MapKeyColumn(name = "float_key")
    @Column(name = "float_value")
    private Map<LocalDateTime, Float> floatValue;
    @ElementCollection
    @CollectionTable(name = "long_map_entries", joinColumns = @JoinColumn(name = "long_map_id"))
    @MapKeyColumn(name = "long_key")
    @Column(name = "long_value")
    private Map<LocalDateTime,Long> longValue;
    @ElementCollection
    @CollectionTable(name = "bool_map_entries", joinColumns = @JoinColumn(name = "bool_map_id"))
    @MapKeyColumn(name = "bool_key")
    @Column(name = "bool_value")
    private Map<LocalDateTime,Boolean> boolValue;

}
