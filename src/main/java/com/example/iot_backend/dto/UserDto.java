package com.example.iot_backend.dto;

import com.example.iot_backend.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends AbstractEntityDto{
    private String lastName;
    private Role role;
    private String email;
    private String login;
    private String password;
}
