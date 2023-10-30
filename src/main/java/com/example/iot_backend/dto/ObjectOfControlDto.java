package com.example.iot_backend.dto;

import com.example.iot_backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ObjectOfControlDto extends AbstractEntityDto{
    private String locationCountry;
    private String locationAddress;
    private List<UserDto> users;
    private List<RoomDto> rooms;
}
