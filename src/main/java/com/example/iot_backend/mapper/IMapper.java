package com.example.iot_backend.mapper;

public interface IMapper<Entity,Dto> {
    Dto toDto(Entity entity);
    Entity toEntity(Dto dto);
}
