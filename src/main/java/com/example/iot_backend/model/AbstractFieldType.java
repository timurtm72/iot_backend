package com.example.iot_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractFieldType <Value>  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;
    @Column(name="time_stamp",nullable = false)
    private LocalDateTime timeStamp;
    @Column(name="value",nullable = false)
    private Value value;
    @PrePersist
    public void toCreate(){
        this.setTimeStamp(LocalDateTime.now());
    }
}
