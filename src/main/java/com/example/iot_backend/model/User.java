package com.example.iot_backend.model;

import com.example.iot_backend.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@SQLDelete(sql = "UPDATE users SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class User extends AbstractEntity{
    @Column(name="last_name",nullable = false)
    private String lastName;
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name="email",nullable = false)
    private String email;
    @Column(name="login",nullable = false)
    private String login;
    @Column(name="password",nullable = false)
    private String password;
}
