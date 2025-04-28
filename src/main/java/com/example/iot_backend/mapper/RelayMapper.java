package com.example.iot_backend.mapper; // Пакет для мапперов

import com.example.iot_backend.dto.RelayDto; // Импорт RelayDto
import com.example.iot_backend.model.initial.Relay; // Импорт сущности Relay
import com.example.iot_backend.utils.MapperUtil; // Импорт утилиты MapperUtil
import lombok.RequiredArgsConstructor; // Импорт аннотации Lombok для генерации конструктора для final полей
import org.springframework.stereotype.Component; // Импорт аннотации Component для регистрации бина в Spring

/**
 * Маппер для преобразования между сущностью Relay и RelayDto.
 */
@Component // Указывает, что этот класс является компонентом Spring и должен быть управляем контейнером
@RequiredArgsConstructor // Генерирует конструктор с одним параметром для поля mapperUtil
public class RelayMapper implements IMapper<Relay, RelayDto> { // Реализация интерфейса IMapper для Relay и RelayDto

    private final MapperUtil mapperUtil; // Поле для хранения экземпляра MapperUtil, внедряется через конструктор
    private final BitDataMapper bitDataMapper; // Внедрение маппера для вложенных данных BitData

    /**
     * Преобразует сущность Relay в RelayDto.
     * Требует ручного маппинга для списка relayValues.
     * @param relay Сущность Relay
     * @return RelayDto DTO
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса
    public RelayDto toDto(Relay relay) { // Реализация метода преобразования в DTO
        RelayDto dto = mapperUtil.getMapper().map(relay, RelayDto.class); // Базовый маппинг полей (id)
        // Ручной маппинг списка BitData в BitDataDto
        if (relay.getRelayValues() != null) { // Проверка на null перед маппингом списка
            dto.setRelayValues(relay.getRelayValues().stream() // Получение потока из списка сущностей BitData
                    .map(bitDataMapper::toDto) // Преобразование каждого BitData в BitDataDto с помощью bitDataMapper
                    .toList()); // Сбор результата в новый список List<BitDataDto>
        }
        return dto; // Возврат DTO с заполненным списком
    }

    /**
     * Преобразует RelayDto в сущность Relay.
     * Требует ручного маппинга для списка relayValues.
     * @param relayDto DTO RelayDto
     * @return Relay Сущность
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса
    public Relay toEntity(RelayDto relayDto) { // Реализация метода преобразования в сущность
        Relay entity = mapperUtil.getMapper().map(relayDto, Relay.class); // Базовый маппинг полей (id)
        // Ручной маппинг списка BitDataDto в BitData
        if (relayDto.getRelayValues() != null) { // Проверка на null перед маппингом списка
            entity.setRelayValues(relayDto.getRelayValues().stream() // Получение потока из списка DTO BitDataDto
                    .map(bitDataMapper::toEntity) // Преобразование каждого BitDataDto в BitData с помощью bitDataMapper
                    .toList()); // Сбор результата в новый список List<BitData>
        }
        return entity; // Возврат сущности с заполненным списком
    }
}