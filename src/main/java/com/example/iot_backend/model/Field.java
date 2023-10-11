package com.example.iot_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@Entity
@Table(name="filed")
@SQLDelete(sql = "UPDATE field SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class Field extends AbstractEntity{
    
}
