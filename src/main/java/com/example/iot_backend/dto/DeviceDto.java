package com.example.iot_backend.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class DeviceDto extends AbstractEntityDto{
    @NotEmpty
    @NotBlank(message = "Список полей устройств не может быть пустым")
    @Valid
    List<FloatTypeFieldDto> floatTypeDeviceFields;
    @NotEmpty
    @NotBlank(message = "Список полей устройств не может быть пустым")
    @Valid
    List<LongTypeFieldDto> longTypeDeviceFields;
    @NotEmpty
    @NotBlank(message = "Список полей устройств не может быть пустым")
    @Valid
    List<BoolTypeFieldDto> boolTypeDeviceFields;
}
