package com.example.iot_backend.model.data;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Класс для хранения бинарных данных (вкл/выкл).
 * Используется для представления состояний переключателей и реле.
 */
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class BitData {
    /**
     * Бинарное значение (истина/ложь)
     */
    @Column(name = "value", nullable = false)
    private Boolean value;

    /**
     * Временная метка измерения
     */
    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;
}
