package com.example.iot_backend.model.object;

import com.example.iot_backend.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="users")
@SQLDelete(sql = "UPDATE users SET is_removed = true WHERE id = ?")
@Where(clause = "is_removed=false")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;
    @Column(name="first_name",nullable = false)
    private String firstName;
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
    @ManyToMany(mappedBy = "users")
    private List<Home> homes;
}
