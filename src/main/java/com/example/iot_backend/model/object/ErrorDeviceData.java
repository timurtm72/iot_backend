package com.example.iot_backend.model.object;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class ErrorDeviceData{
    private Integer errorCode;
    private String errorDescription;
}