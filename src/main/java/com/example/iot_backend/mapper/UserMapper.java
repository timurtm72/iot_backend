package com.example.iot_backend.mapper;

import com.example.iot_backend.dto.UserDto;
import com.example.iot_backend.model.object.User;
import com.example.iot_backend.utils.MapperUtil;

public class UserMapper implements IMapper<User, UserDto>{
    private final MapperUtil mapperUtil;

    public UserMapper(MapperUtil mapperUtil) {
        this.mapperUtil = mapperUtil;
    }

    @Override
    public UserDto toDto(User user) {
        return mapperUtil.getMapper().map(user, UserDto.class);
    }

    @Override
    public User toEntity(UserDto userDto) {
        return mapperUtil.getMapper().map(userDto, User.class);
    }
}
