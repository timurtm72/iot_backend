package com.example.iot_backend.mapper;

import com.example.iot_backend.dto.WiFiParametersDto;
import com.example.iot_backend.model.settings.WiFiParameters;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

/**
 * Маппер для преобразования между сущностью WiFiParameters и WiFiParametersDto.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface WiFiParametersMapper {

    /**
     * Преобразует сущность WiFiParameters в WiFiParametersDto.
     * @param wiFiParameters Сущность WiFiParameters
     * @return WiFiParametersDto DTO
     */
    WiFiParametersDto toDto(WiFiParameters wiFiParameters);

    /**
     * Преобразует WiFiParametersDto в сущность WiFiParameters.
     * @param wiFiParametersDto DTO WiFiParametersDto
     * @return WiFiParameters Сущность
     */
    @Mapping(target = "securityType", ignore = true)
    WiFiParameters toEntity(WiFiParametersDto wiFiParametersDto);
}