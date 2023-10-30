package com.example.iot_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto extends AbstractEntityDto{
    private List<SensorDto> sensors;
    private List<DeviceDto> devices;
}
