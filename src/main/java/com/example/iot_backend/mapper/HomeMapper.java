package com.example.iot_backend.mapper; // Объявление пакета для мапперов

import com.example.iot_backend.dto.HomeDto; // Импорт DTO для дома
import com.example.iot_backend.model.object.Home; // Импорт сущности Home (предполагаемый путь, исправьте при необходимости)
import com.example.iot_backend.utils.MapperUtil; // Импорт утилиты MapperUtil
import com.example.iot_backend.mapper.IMapper; // Импорт базового интерфейса маппера
import lombok.RequiredArgsConstructor; // Импорт аннотации Lombok для генерации конструктора для final полей
import org.springframework.stereotype.Component; // Импорт аннотации Component для регистрации бина в Spring

/**
 * Маппер для преобразования между сущностью Home и HomeDto. // JavaDoc комментарий для класса
 */
@Component // Указывает, что этот класс является компонентом Spring и должен управляться контейнером Spring
@RequiredArgsConstructor // Генерирует конструктор с одним параметром для каждого final поля (в данном случае, для mapperUtil)
public class HomeMapper implements IMapper<Home, HomeDto> { // Объявление класса HomeMapper, реализующего интерфейс IMapper для типов Home и HomeDto

    private final MapperUtil mapperUtil; // Объявление неизменяемого (final) поля для хранения экземпляра MapperUtil, будет внедрено через конструктор

    /**
     * Преобразует сущность Home в HomeDto. // JavaDoc комментарий для метода toDto
     * @param home Сущность Home // Описание параметра home
     * @return HomeDto DTO // Описание возвращаемого значения
     */
    @Override // Аннотация указывает, что этот метод переопределяет метод из интерфейса IMapper
    public HomeDto toDto(Home home) { // Реализация метода для преобразования сущности Home в HomeDto
        // Использует ModelMapper, полученный из MapperUtil, для копирования данных из сущности home в новый объект HomeDto
        return mapperUtil.getMapper().map(home, HomeDto.class); // Возвращает созданный объект HomeDto
    }

    /**
     * Преобразует HomeDto в сущность Home. // JavaDoc комментарий для метода toEntity
     * @param homeDto DTO HomeDto // Описание параметра homeDto
     * @return Home Сущность // Описание возвращаемого значения
     */
    @Override // Аннотация указывает, что этот метод переопределяет метод из интерфейса IMapper
    public Home toEntity(HomeDto homeDto) { // Реализация метода для преобразования HomeDto в сущность Home
        // Использует ModelMapper, полученный из MapperUtil, для копирования данных из DTO homeDto в новый объект Home
        return mapperUtil.getMapper().map(homeDto, Home.class); // Возвращает созданный объект Home
    }
}