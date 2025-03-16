package com.example.iot_backend.model.object;

import com.example.iot_backend.model.base.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_id", nullable = false)
    private Home home;
}
