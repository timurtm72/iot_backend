package com.example.iot_backend.mapper; // Пакет для мапперов

import com.example.iot_backend.dto.RegulatorDeviceDto; // Импорт DTO для устройства-регулятора
import com.example.iot_backend.model.device.RegulatorDevice; // Импорт сущности RegulatorDevice (предполагаемый путь, исправьте при необходимости)
import com.example.iot_backend.utils.MapperUtil; // Импорт утилиты MapperUtil
import com.example.iot_backend.mapper.IMapper; // Импорт базового интерфейса маппера
import lombok.RequiredArgsConstructor; // Импорт аннотации Lombok для генерации конструктора для final полей
import org.springframework.stereotype.Component; // Импорт аннотации Component для регистрации бина в Spring

/**
 * Маппер для преобразования между сущностью RegulatorDevice и RegulatorDeviceDto.
 */
@Component // Указывает, что этот класс является компонентом Spring и должен быть управляем контейнером
@RequiredArgsConstructor // Генерирует конструктор с одним параметром для поля mapperUtil (для final полей)
public class RegulatorDeviceMapper implements IMapper<RegulatorDevice, RegulatorDeviceDto> { // Реализация интерфейса IMapper для RegulatorDevice и RegulatorDeviceDto

    private final MapperUtil mapperUtil; // Поле для хранения экземпляра MapperUtil, внедряется через конструктор

    /**
     * Преобразует сущность RegulatorDevice в RegulatorDeviceDto.
     * @param regulatorDevice Сущность RegulatorDevice
     * @return RegulatorDeviceDto DTO
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса IMapper
    public RegulatorDeviceDto toDto(RegulatorDevice regulatorDevice) { // Реализация метода преобразования сущности в DTO
        // Использует ModelMapper из MapperUtil для копирования данных из сущности в новый объект DTO
        return mapperUtil.getMapper().map(regulatorDevice, RegulatorDeviceDto.class); // Возвращает созданный DTO
    }

    /**
     * Преобразует RegulatorDeviceDto в сущность RegulatorDevice.
     * @param regulatorDeviceDto DTO RegulatorDeviceDto
     * @return RegulatorDevice Сущность
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса IMapper
    public RegulatorDevice toEntity(RegulatorDeviceDto regulatorDeviceDto) { // Реализация метода преобразования DTO в сущность
        // Использует ModelMapper из MapperUtil для копирования данных из DTO в новый объект сущности
        return mapperUtil.getMapper().map(regulatorDeviceDto, RegulatorDevice.class); // Возвращает созданную сущность
    }
}