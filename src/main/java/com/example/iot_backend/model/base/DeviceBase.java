package com.example.iot_backend.model.base;

import com.example.iot_backend.model.object.ErrorDeviceData;
import com.example.iot_backend.model.object.FloatDeviceData;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@MappedSuperclass
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class DeviceBase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "in_out_type", nullable = false)
    private String inOutType;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "value_name", nullable = false)
    private String valueName;
}