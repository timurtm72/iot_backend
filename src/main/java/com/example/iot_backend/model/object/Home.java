package com.example.iot_backend.model.object;

import com.example.iot_backend.model.base.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import java.util.List;

/**
 * Класс, представляющий дом или помещение с комнатами.
 * Используется для группировки комнат и устройств.
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "home")
@SQLDelete(sql = "UPDATE home SET is_removed = true WHERE id = ?")
@SQLRestriction("is_removed=false")
public class Home extends AbstractEntity {
    /**
     * Географическое местоположение дома
     */
    @Embedded
    private Location location;
    
    /**
     * Список комнат в доме
     */
    @OneToMany(mappedBy = "home", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms;
    
    /**
     * Список пользователей, имеющих доступ к дому
     */
    @ManyToMany
    @JoinTable(
            name = "home_users",
            joinColumns = @JoinColumn(name = "home_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
}
