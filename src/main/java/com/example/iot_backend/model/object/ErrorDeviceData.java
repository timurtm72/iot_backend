package com.example.iot_backend.model.object;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class ErrorDeviceData{
    private Long id;
    private Integer errorCode;
    private String errorDescription;
}