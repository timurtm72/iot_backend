package com.example.iot_backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    @NotBlank(message = "Список датчиков не может быть пустым")
    @Valid
    private List<SensorDto> sensors;
    @NotEmpty
    @NotBlank(message = "Список устройств не может быть пустым")
    @Valid
    private List<DeviceDto> devices;
}
