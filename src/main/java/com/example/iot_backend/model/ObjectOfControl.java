package com.example.iot_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="object_of_control")
public class ObjectOfControl {
    @Id
    private Long id;
    private String name;
    private String description;
    private List<User> users;
    private String locationCountry;
    private String locationAddress;



}
