package com.example.iot_backend.mapper;

import com.example.iot_backend.dto.RoomDto;
import com.example.iot_backend.model.object.Room;
import com.example.iot_backend.utils.MapperUtil;

public class RoomMapper implements IMapper<Room, RoomDto>{
    private final MapperUtil mapperUtil;

    public RoomMapper(MapperUtil mapperUtil) {
        this.mapperUtil = mapperUtil;
    }

    @Override
    public RoomDto toDto(Room room) {
        RoomDto roomDto = mapperUtil.getMapper().map(room, RoomDto.class);
//        roomDto.setSensors(mapperUtil.mapList(room.getSensors(), SensorDto.class));
//        roomDto.setDevices(mapperUtil.mapList(room.getDevices(), DeviceDto.class));
        return roomDto;
    }

    @Override
    public Room toEntity(RoomDto roomDto) {
        Room room = mapperUtil.getMapper().map(roomDto, Room.class);
//        room.setSensors(mapperUtil.mapList(roomDto.getSensors(), Sensor.class));
//        room.setDevices(mapperUtil.mapList(roomDto.getDevices(), Device.class));
        return room;
    }
}
