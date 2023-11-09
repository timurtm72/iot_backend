package com.example.iot_backend.mapper;

import com.example.iot_backend.dto.*;
import com.example.iot_backend.model.*;
import com.example.iot_backend.utils.MapperUtil;

public class SensorMapper implements IMapper<Sensor, SensorDto>{
    private final MapperUtil mapperUtil;

    public SensorMapper(MapperUtil mapperUtil) {
        this.mapperUtil = mapperUtil;
    }

    @Override
    public SensorDto toDto(Sensor sensor) {
        SensorDto sensorDto = mapperUtil.getMapper().map(sensor, SensorDto.class);
        sensorDto.setFloatTypeSensorFields(mapperUtil.mapList(sensor.getFloatTypeSensorFields(), FloatTypeFieldDto.class));
        sensorDto.setBoolTypeSensorFields(mapperUtil.mapList(sensor.getBoolTypeSensorFields(), BoolTypeFieldDto.class));
        sensorDto.setLongTypeSensorFields(mapperUtil.mapList(sensor.getLongTypeSensorFields(), LongTypeFieldDto.class));
        return sensorDto;
    }

    @Override
    public Sensor toEntity(SensorDto sensorDto) {
        Sensor sensor = mapperUtil.getMapper().map(sensorDto, Sensor.class);
        sensor.setFloatTypeSensorFields(mapperUtil.mapList(sensorDto.getFloatTypeSensorFields(), FloatTypeField.class));
        sensor.setBoolTypeSensorFields(mapperUtil.mapList(sensorDto.getBoolTypeSensorFields(), BoolTypeField.class));
        sensor.setLongTypeSensorFields(mapperUtil.mapList(sensorDto.getLongTypeSensorFields(), LongTypeField.class));
        return sensor;
    }
}
