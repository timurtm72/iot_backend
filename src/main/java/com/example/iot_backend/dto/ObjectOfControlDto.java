package com.example.iot_backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ObjectOfControlDto extends AbstractEntityDto{
    @NotBlank(message = "Страна локации не может быть пустым")
    private String locationCountry;
    @NotBlank(message = "Адрес локации не может быть пустым")
    private String locationAddress;
    @NotEmpty
    @NotBlank(message = "Список пользователей не может быть пустым")
    @Valid
    private List<UserDto> users;
    @NotEmpty
    @NotBlank(message = "Список комнат не может быть пустым")
    @Valid
    private List<RoomDto> rooms;
}
