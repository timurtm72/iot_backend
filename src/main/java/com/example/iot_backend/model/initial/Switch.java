package com.example.iot_backend.model.initial;

import com.example.iot_backend.model.data.BitData;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

/**
 * Переключатель (цифровой вход).
 * Представляет физический выключатель или датчик с бинарными значениями.
 */
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "switch")
@SQLDelete(sql = "UPDATE switch SET is_removed = true WHERE id = ?")
@SQLRestriction("is_removed=false")
public class Switch {
    /**
     * Уникальный идентификатор переключателя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Коллекция бинарных значений переключателя
     */
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
        name = "switch_values",
        joinColumns = @JoinColumn(name = "switch_id")
    )
    private List<BitData> switchValues;
    
    /**
     * Флаг удаления для мягкого удаления записей
     */
    @Column(name = "is_removed", nullable = false)
    private boolean isRemoved = Boolean.FALSE;
}