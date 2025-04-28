package com.example.iot_backend.mapper; // Пакет для мапперов

import com.example.iot_backend.dto.WiFiParametersDto; // Импорт DTO для параметров WiFi
import com.example.iot_backend.model.settings.WiFiParameters; // Импорт сущности WiFiParameters (предполагаемый путь, исправьте при необходимости)
import com.example.iot_backend.utils.MapperUtil; // Импорт утилиты MapperUtil
import com.example.iot_backend.mapper.IMapper; // Импорт базового интерфейса маппера
import lombok.RequiredArgsConstructor; // Импорт аннотации Lombok для генерации конструктора для final полей
import org.springframework.stereotype.Component; // Импорт аннотации Component для регистрации бина в Spring

/**
 * Маппер для преобразования между сущностью WiFiParameters и WiFiParametersDto.
 */
@Component // Указывает, что этот класс является компонентом Spring и должен быть управляем контейнером
@RequiredArgsConstructor // Генерирует конструктор с одним параметром для поля mapperUtil (для final полей)
public class WiFiParametersMapper implements IMapper<WiFiParameters, WiFiParametersDto> { // Реализация интерфейса IMapper для WiFiParameters и WiFiParametersDto

    private final MapperUtil mapperUtil; // Поле для хранения экземпляра MapperUtil, внедряется через конструктор

    /**
     * Преобразует сущность WiFiParameters в WiFiParametersDto.
     * @param wiFiParameters Сущность WiFiParameters
     * @return WiFiParametersDto DTO
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса IMapper
    public WiFiParametersDto toDto(WiFiParameters wiFiParameters) { // Реализация метода преобразования сущности в DTO
        // Использует ModelMapper из MapperUtil для копирования данных из сущности в новый объект DTO
        return mapperUtil.getMapper().map(wiFiParameters, WiFiParametersDto.class);
    }

    /**
     * Преобразует WiFiParametersDto в сущность WiFiParameters.
     * @param wiFiParametersDto DTO WiFiParametersDto
     * @return WiFiParameters Сущность
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса IMapper
    public WiFiParameters toEntity(WiFiParametersDto wiFiParametersDto) { // Реализация метода преобразования DTO в сущность
        // Использует ModelMapper из MapperUtil для копирования данных из DTO в новый объект сущности
        return mapperUtil.getMapper().map(wiFiParametersDto, WiFiParameters.class);
    }
}