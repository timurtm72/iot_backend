package com.example.iot_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@Entity
@Table(name = "float_type_field")
@SQLDelete(sql = "UPDATE devices SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class FloatTypeField  extends AbstractFieldType<Float>{
}
