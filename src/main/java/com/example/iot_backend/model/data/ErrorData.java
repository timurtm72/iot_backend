package com.example.iot_backend.model.data;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class ErrorData {
    @Column(name = "error_code", nullable = false)
    private Integer errorCode;
    
    @Column(name = "error_description")
    private String errorDescription;
}