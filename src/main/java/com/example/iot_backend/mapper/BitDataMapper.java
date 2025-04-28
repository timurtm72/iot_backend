package com.example.iot_backend.mapper; // Пакет для мапперов

import com.example.iot_backend.dto.BitDataDto; // Импорт BitDataDto
import com.example.iot_backend.model.data.BitData; // Импорт встраиваемого класса BitData
import com.example.iot_backend.utils.MapperUtil; // Импорт утилиты MapperUtil
import lombok.RequiredArgsConstructor; // Импорт аннотации Lombok для генерации конструктора для final полей
import org.springframework.stereotype.Component; // Импорт аннотации Component для регистрации бина в Spring

/**
 * Маппер для преобразования между встраиваемым классом BitData и BitDataDto.
 */
@Component // Указывает, что этот класс является компонентом Spring и должен быть управляем контейнером
@RequiredArgsConstructor // Генерирует конструктор с одним параметром для поля mapperUtil
public class BitDataMapper implements IMapper<BitData, BitDataDto> { // Реализация интерфейса IMapper для BitData и BitDataDto

    private final MapperUtil mapperUtil; // Поле для хранения экземпляра MapperUtil, внедряется через конструктор

    /**
     * Преобразует BitData в BitDataDto.
     * @param bitData Встраиваемый объект BitData
     * @return BitDataDto DTO
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса
    public BitDataDto toDto(BitData bitData) { // Реализация метода преобразования в DTO
        return mapperUtil.getMapper().map(bitData, BitDataDto.class); // Использование ModelMapper для преобразования bitData в BitDataDto
    }

    /**
     * Преобразует BitDataDto в BitData.
     * @param bitDataDto DTO BitDataDto
     * @return BitData Встраиваемый объект
     */
    @Override // Аннотация указывает, что метод переопределяет метод из интерфейса
    public BitData toEntity(BitDataDto bitDataDto) { // Реализация метода преобразования в сущность (в данном случае, встраиваемый объект)
        return mapperUtil.getMapper().map(bitDataDto, BitData.class); // Использование ModelMapper для преобразования bitDataDto в BitData
    }
}