package com.example.iot_backend.mapper; // Пакет для мапперов

import com.example.iot_backend.dto.SwitchDto; // Импорт SwitchDto
import com.example.iot_backend.model.initial.Switch; // Импорт сущности Switch
import com.example.iot_backend.utils.MapperUtil; // Импорт утилиты MapperUtil
import lombok.RequiredArgsConstructor; // Импорт аннотации Lombok для генерации конструктора для final полей
import org.springframework.stereotype.Component; // Импорт аннотации Component для регистрации бина в Spring

/**
 * Маппер для преобразования между сущностью Switch и SwitchDto.
 */
@Component // Указывает, что этот класс является компонентом Spring и должен быть управляем контейнером
@RequiredArgsConstructor // Генерирует конструктор с одним параметром для поля mapperUtil
public class SwitchMapper implements IMapper<Switch, SwitchDto> { // Реализация интерфейса IMapper для Switch и SwitchDto

    private final MapperUtil mapperUtil; // Поле для хранения экземпляра MapperUtil, внедряется через конструктор
    private final BitDataMapper bitDataMapper; // Внедрение маппера для вложенных данных BitData

    /**
     * Преобразует сущность Switch в SwitchDto.
     * Требует ручного маппинга для списка switchValues.
     * @param switchEntity Сущность Switch
     * @return SwitchDto DTO
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса
    public SwitchDto toDto(Switch switchEntity) { // Реализация метода преобразования в DTO
        SwitchDto dto = mapperUtil.getMapper().map(switchEntity, SwitchDto.class); // Базовый маппинг полей (id)
        // Ручной маппинг списка BitData в BitDataDto
        if (switchEntity.getSwitchValues() != null) { // Проверка на null перед маппингом списка
            dto.setSwitchValues(switchEntity.getSwitchValues().stream() // Получение потока из списка сущностей BitData
                    .map(bitDataMapper::toDto) // Преобразование каждого BitData в BitDataDto с помощью bitDataMapper
                    .toList()); // Сбор результата в новый список List<BitDataDto>
        }
        return dto; // Возврат DTO с заполненным списком
    }

    /**
     * Преобразует SwitchDto в сущность Switch.
     * Требует ручного маппинга для списка switchValues.
     * @param switchDto DTO SwitchDto
     * @return Switch Сущность
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса
    public Switch toEntity(SwitchDto switchDto) { // Реализация метода преобразования в сущность
        Switch entity = mapperUtil.getMapper().map(switchDto, Switch.class); // Базовый маппинг полей (id)
        // Ручной маппинг списка BitDataDto в BitData
        if (switchDto.getSwitchValues() != null) { // Проверка на null перед маппингом списка
            entity.setSwitchValues(switchDto.getSwitchValues().stream() // Получение потока из списка DTO BitDataDto
                    .map(bitDataMapper::toEntity) // Преобразование каждого BitDataDto в BitData с помощью bitDataMapper
                    .toList()); // Сбор результата в новый список List<BitData>
        }
        return entity; // Возврат сущности с заполненным списком
    }
}