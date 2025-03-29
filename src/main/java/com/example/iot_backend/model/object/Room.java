package com.example.iot_backend.model.object;

import com.example.iot_backend.model.base.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * Класс, представляющий комнату в доме.
 * Используется для группировки устройств по их расположению.
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "room")
@SQLDelete(sql = "UPDATE room SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class Room extends AbstractEntity {
    /**
     * Связь с домом, в котором находится комната
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_id", nullable = false)
    private Home home;
}
