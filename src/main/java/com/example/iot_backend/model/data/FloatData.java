package com.example.iot_backend.model.data;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class FloatData {
    @Column(name = "value", nullable = false)
    private Float value;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;
}