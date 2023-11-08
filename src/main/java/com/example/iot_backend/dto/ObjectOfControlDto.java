package com.example.iot_backend.dto;

import java.util.List;

public class ObjectOfControlDto extends AbstractEntityDto{
    private String locationCountry;
    private String locationAddress;
    private List<UserDto> users;
    private List<RoomDto> rooms;
}
