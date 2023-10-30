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
public class SensorDto extends AbstractEntityDto{
    @NotEmpty
    @NotBlank(message = "Список полей не может быть пустым")
    @Valid
    List<FloatTypeFieldDto> floatTypeSensorFields;
    @NotEmpty
    @NotBlank(message = "Список полей не может быть пустым")
    @Valid
    List<LongTypeFieldDto> longTypeSensorFields;
    @NotEmpty
    @NotBlank(message = "Список полей не может быть пустым")
    @Valid
    List<BoolTypeFieldDto> boolTypeSensorFields;
}
