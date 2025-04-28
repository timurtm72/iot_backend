package com.example.iot_backend.dto;

import com.example.iot_backend.enums.Role; // Импорт перечисления Role
import jakarta.validation.constraints.Email; // Импорт аннотации для валидации email
import jakarta.validation.constraints.NotBlank; // Импорт аннотации для проверки на пустоту (и пробелы)
import jakarta.validation.constraints.NotNull; // Импорт аннотации для проверки на null
import jakarta.validation.constraints.Size; // Импорт аннотации для проверки размера
import lombok.*; // Импорт аннотаций Lombok

@EqualsAndHashCode // Генерирует методы equals и hashCode
@NoArgsConstructor // Генерирует конструктор без аргументов
@AllArgsConstructor // Генерирует конструктор со всеми полями
@Getter // Генерирует геттеры
@Setter // Генерирует сеттеры
@ToString // Генерирует метод toString
public class UserDto {
    // Идентификатор пользователя (может быть null при создании)
    private Long id;

    // Имя пользователя
    @NotBlank(message = "Имя не может быть пустым") // Поле не должно быть пустым или содержать только пробелы
    @Size(min = 2, max = 50, message = "Имя должно быть от 2 до 50 символов") // Длина имени от 2 до 50 символов
    private String firstName;

    // Фамилия пользователя
    @NotBlank(message = "Фамилия не может быть пустой") // Поле не должно быть пустым
    @Size(min = 2, max = 50, message = "Фамилия должна быть от 2 до 50 символов") // Длина фамилии от 2 до 50 символов
    private String lastName;

    // Роль пользователя
    @NotNull(message = "Роль пользователя обязательна") // Поле не должно быть null
    private Role role;

    // Email пользователя
    @NotBlank(message = "Email не может быть пустым") // Поле не должно быть пустым
    @Email(message = "Некорректный формат email") // Поле должно соответствовать формату email
    private String email;

    // Логин пользователя
    @NotBlank(message = "Логин не может быть пустым") // Поле не должно быть пустым
    @Size(min = 4, max = 20, message = "Логин должен быть от 4 до 20 символов") // Длина логина от 4 до 20 символов
    private String login;

    // Пароль пользователя
    @NotBlank(message = "Пароль не может быть пустым") // Поле не должно быть пустым
    @Size(min = 6, message = "Пароль должен содержать минимум 6 символов") // Длина пароля минимум 6 символов
    private String password;
}