package com.example.iot_backend.model.base;

import com.example.iot_backend.enums.RegMode;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@MappedSuperclass
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class RegulatorDeviceBase  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ip_address", nullable = false)
    private String ipAddress;
    @Column(name = "reg_mode")
    @Enumerated(EnumType.STRING)
    private RegMode regMode;
    @Column(name = "set_value", nullable = false)
    private Float setValue;

    @Column(name = "hysteresis", nullable = false)
    private Float hysteresis;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "value_name", nullable = false)
    private String valueName;
}
