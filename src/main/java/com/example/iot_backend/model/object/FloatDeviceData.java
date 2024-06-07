package com.example.iot_backend.model.object;
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
public class FloatDeviceData {
    private Float value;
    private LocalDateTime timestamp;
}
