package com.example.iot_backend.mapper; // Пакет для мапперов

import com.example.iot_backend.dto.SensorDto; // Импорт SensorDto
import com.example.iot_backend.model.initial.Sensor; // Импорт сущности Sensor
import com.example.iot_backend.utils.MapperUtil; // Импорт утилиты MapperUtil
import lombok.RequiredArgsConstructor; // Импорт аннотации Lombok для генерации конструктора для final полей
import org.springframework.stereotype.Component; // Импорт аннотации Component для регистрации бина в Spring

/**
 * Маппер для преобразования между сущностью Sensor и SensorDto.
 */
@Component // Указывает, что этот класс является компонентом Spring и должен быть управляем контейнером
@RequiredArgsConstructor // Генерирует конструктор с одним параметром для поля mapperUtil
public class SensorMapper implements IMapper<Sensor, SensorDto> { // Реализация интерфейса IMapper для Sensor и SensorDto

    private final MapperUtil mapperUtil; // Поле для хранения экземпляра MapperUtil, внедряется через конструктор
    private final FloatDataMapper floatDataMapper; // Внедрение маппера для вложенных данных FloatData

    /**
     * Преобразует сущность Sensor в SensorDto.
     * Требует ручного маппинга для списка sensorValues.
     * @param sensor Сущность Sensor
     * @return SensorDto DTO
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса
    public SensorDto toDto(Sensor sensor) { // Реализация метода преобразования в DTO
        SensorDto dto = mapperUtil.getMapper().map(sensor, SensorDto.class); // Базовый маппинг полей (id)
        // Ручной маппинг списка FloatData в FloatDataDto
        if (sensor.getSensorValues() != null) { // Проверка на null перед маппингом списка
            dto.setSensorValues(sensor.getSensorValues().stream() // Получение потока из списка сущностей FloatData
                    .map(floatDataMapper::toDto) // Преобразование каждого FloatData в FloatDataDto с помощью floatDataMapper
                    .toList()); // Сбор результата в новый список List<FloatDataDto>
        }
        return dto; // Возврат DTO с заполненным списком
    }

    /**
     * Преобразует SensorDto в сущность Sensor.
     * Требует ручного маппинга для списка sensorValues.
     * @param sensorDto DTO SensorDto
     * @return Sensor Сущность
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса
    public Sensor toEntity(SensorDto sensorDto) { // Реализация метода преобразования в сущность
        Sensor entity = mapperUtil.getMapper().map(sensorDto, Sensor.class); // Базовый маппинг полей (id)
        // Ручной маппинг списка FloatDataDto в FloatData
        if (sensorDto.getSensorValues() != null) { // Проверка на null перед маппингом списка
            entity.setSensorValues(sensorDto.getSensorValues().stream() // Получение потока из списка DTO FloatDataDto
                    .map(floatDataMapper::toEntity) // Преобразование каждого FloatDataDto в FloatData с помощью floatDataMapper
                    .toList()); // Сбор результата в новый список List<FloatData>
        }
        return entity; // Возврат сущности с заполненным списком
    }
}