package com.example.iot_backend.model.data;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Класс для хранения данных с плавающей точкой.
 * Используется для представления аналоговых показаний датчиков.
 */
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class FloatData {
    /**
     * Значение с плавающей точкой
     */
    @Column(name = "value", nullable = false)
    private Float value;

    /**
     * Временная метка измерения
     */
    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;
}