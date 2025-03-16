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
public abstract class RegulatorDeviceBase extends AbstractEntity implements Serializable {
    @Column(name = "reg_mode")
    @Enumerated(EnumType.STRING)
    private RegMode regMode;

    @Column(name = "set_value", nullable = false)
    private Float value;

    @Column(name = "value_name", nullable = false)
    private String valueName;

    @Column(name = "low_hysteresis", nullable = false)
    private Float lowHysteresis;

    @Column(name = "high_hysteresis", nullable = false)
    private Float highHysteresis;

    @Column(name = "description", nullable = false)
    private String description;


}
