package com.example.iot_backend.mapper; // Пакет для мапперов

import com.example.iot_backend.dto.SwitchDeviceDto; // Импорт DTO для устройства-переключателя
import com.example.iot_backend.model.device.SwitchDevice; // Импорт сущности SwitchDevice (предполагаемый путь, исправьте при необходимости)
import com.example.iot_backend.utils.MapperUtil; // Импорт утилиты MapperUtil
import com.example.iot_backend.mapper.IMapper; // Импорт базового интерфейса маппера
import lombok.RequiredArgsConstructor; // Импорт аннотации Lombok для генерации конструктора для final полей
import org.springframework.stereotype.Component; // Импорт аннотации Component для регистрации бина в Spring

/**
 * Маппер для преобразования между сущностью SwitchDevice и SwitchDeviceDto.
 */
@Component // Указывает, что этот класс является компонентом Spring и должен быть управляем контейнером
@RequiredArgsConstructor // Генерирует конструктор с одним параметром для поля mapperUtil (для final полей)
public class SwitchDeviceMapper implements IMapper<SwitchDevice, SwitchDeviceDto> { // Реализация интерфейса IMapper для SwitchDevice и SwitchDeviceDto

    private final MapperUtil mapperUtil; // Поле для хранения экземпляра MapperUtil, внедряется через конструктор

    /**
     * Преобразует сущность SwitchDevice в SwitchDeviceDto.
     * @param switchDevice Сущность SwitchDevice
     * @return SwitchDeviceDto DTO
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса IMapper
    public SwitchDeviceDto toDto(SwitchDevice switchDevice) { // Реализация метода преобразования сущности в DTO
        // Использует ModelMapper из MapperUtil для копирования данных из сущности в новый объект DTO
        return mapperUtil.getMapper().map(switchDevice, SwitchDeviceDto.class);
    }

    /**
     * Преобразует SwitchDeviceDto в сущность SwitchDevice.
     * @param switchDeviceDto DTO SwitchDeviceDto
     * @return SwitchDevice Сущность
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса IMapper
    public SwitchDevice toEntity(SwitchDeviceDto switchDeviceDto) { // Реализация метода преобразования DTO в сущность
        // Использует ModelMapper из MapperUtil для копирования данных из DTO в новый объект сущности
        return mapperUtil.getMapper().map(switchDeviceDto, SwitchDevice.class);
    }
}