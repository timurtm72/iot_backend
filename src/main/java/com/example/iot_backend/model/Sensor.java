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
@Table(name="sensors")
@SQLDelete(sql = "UPDATE sensors SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class Sensor extends AbstractEntity{
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinColumn(name="fields_id")
    List<Field> fields;
}
