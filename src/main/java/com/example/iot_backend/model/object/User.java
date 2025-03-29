package com.example.iot_backend.model.object;

import com.example.iot_backend.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import java.util.List;

/**
 * Класс, представляющий пользователя системы.
 * Содержит информацию об аккаунте и связанных объектах.
 */
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="users")
@SQLDelete(sql = "UPDATE users SET is_removed = true WHERE id = ?")
@SQLRestriction("is_removed=false")
public class User{
    /**
     * Уникальный идентификатор пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;
    
    /**
     * Имя пользователя
     */
    @Column(name="first_name",nullable = false)
    private String firstName;
    
    /**
     * Фамилия пользователя
     */
    @Column(name="last_name",nullable = false)
    private String lastName;
    
    /**
     * Роль пользователя в системе
     */
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    
    /**
     * Электронная почта пользователя
     */
    @Column(name="email",nullable = false)
    private String email;
    
    /**
     * Логин пользователя
     */
    @Column(name="login",nullable = false)
    private String login;
    
    /**
     * Хешированный пароль пользователя
     */
    @Column(name="password",nullable = false)
    private String password;
    
    /**
     * Список домов, к которым имеет доступ пользователь
     */
    @ManyToMany(mappedBy = "users")
    private List<Home> homes;
    
    /**
     * Флаг удаления для мягкого удаления записей
     */
    @Column(name = "is_removed", nullable = false)
    private boolean isRemoved = Boolean.FALSE;
}
