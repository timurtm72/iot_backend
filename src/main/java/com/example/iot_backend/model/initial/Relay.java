package com.example.iot_backend.model.initial;

import com.example.iot_backend.model.data.BitData;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import java.util.List;

/**
 * Реле (цифровой выход).
 * Представляет физическое реле или исполнительный механизм с бинарными значениями.
 */
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "relay")
@SQLDelete(sql = "UPDATE relay SET is_removed = true WHERE id = ?")
@SQLRestriction("is_removed=false")
public class Relay {
    /**
     * Уникальный идентификатор реле
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Коллекция бинарных значений реле
     */
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
        name = "relay_values",
        joinColumns = @JoinColumn(name = "relay_id")
    )
    private List<BitData> relayValues;
    
    /**
     * Флаг удаления для мягкого удаления записей
     */
    @Column(name = "is_removed", nullable = false)
    private boolean isRemoved = Boolean.FALSE;
}