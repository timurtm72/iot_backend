package com.example.iot_backend.dto;
import java.util.List;

public class DeviceDto extends AbstractEntityDto{
    List<FloatTypeFieldDto> floatTypeDeviceFields;
    List<LongTypeFieldDto> longTypeDeviceFields;
    List<BoolTypeFieldDto> boolTypeDeviceFields;
}
