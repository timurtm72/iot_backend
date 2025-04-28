package com.example.iot_backend.dto;

import com.example.iot_backend.enums.Role; // Импорт перечисления Role
import jakarta.validation.constraints.Email; // Аннотации валидации здесь могут быть избыточны для Read DTO, но оставлены для примера
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*; // Импорт аннотаций Lombok

@EqualsAndHashCode // Генерирует методы equals и hashCode
@NoArgsConstructor // Генерирует конструктор без аргументов
@AllArgsConstructor // Генерирует конструктор со всеми полями
@Getter // Генерирует геттеры
@Setter // Генерирует сеттеры
@ToString // Генерирует метод toString
public class UserReadDto {
    // Идентификатор пользователя
    private Long id;

    // Имя пользователя
    @NotBlank(message = "Имя не может быть пустым")
    @Size(min = 2, max = 50, message = "Имя должно быть от 2 до 50 символов")
    private String firstName;

    // Фамилия пользователя
    @NotBlank(message = "Фамилия не может быть пустой")
    @Size(min = 2, max = 50, message = "Фамилия должна быть от 2 до 50 символов")
    private String lastName;

    // Роль пользователя
    @NotNull(message = "Роль пользователя обязательна")
    private Role role;

    // Email пользователя
    @NotBlank(message = "Email не может быть пустым")
    @Email(message = "Некорректный формат email")
    private String email;

    // Логин пользователя
    @NotBlank(message = "Логин не может быть пустым")
    @Size(min = 4, max = 20, message = "Логин должен быть от 4 до 20 символов")
    private String login;

    // Поле password отсутствует, так как это DTO для чтения
}