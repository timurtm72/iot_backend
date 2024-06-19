package com.example.iot_backend.dto;

import com.example.iot_backend.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserReadDto{
    private Long id;
    @NotBlank(message = "Имя не может быть пустым")
    private String firstName;
    @NotBlank(message = "Фамилия не может быть пустой")
    private String lastName;
    @NotNull(message = "Роль пользователя не может быть пустой")
    private Role role;
    @Email
    private String email;
    @NotBlank(message = "Логин не может быть пустым")
    private String login;
}
