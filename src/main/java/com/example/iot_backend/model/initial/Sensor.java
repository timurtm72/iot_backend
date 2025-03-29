package com.example.iot_backend.model.initial;

import com.example.iot_backend.model.data.FloatData;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import java.util.List;

/**
 * Датчик (аналоговый вход).
 * Представляет физический датчик, измеряющий аналоговые величины.
 */
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sensor")
@SQLDelete(sql = "UPDATE sensor SET is_removed = true WHERE id = ?")
@SQLRestriction("is_removed=false")
public class Sensor {
    /**
     * Уникальный идентификатор датчика
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Коллекция значений с плавающей точкой от датчика
     */
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
        name = "sensor_values",
        joinColumns = @JoinColumn(name = "sensor_id")
    )
    private List<FloatData> sensorValues;
    
    /**
     * Флаг удаления для мягкого удаления записей
     */
    @Column(name = "is_removed", nullable = false)
    private boolean isRemoved = Boolean.FALSE;
}
