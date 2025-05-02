package com.example.iot_backend.mapper; // Объявляем пакет, в котором находится этот интерфейс маппера.

import com.example.iot_backend.dto.SwitchDeviceDto; // Импортируем класс SwitchDeviceDto (DTO).
import com.example.iot_backend.model.device.SwitchDevice; // Импортируем класс SwitchDevice (сущность).
import com.example.iot_backend.model.initial.Switch; // Импортируем сущность Switch.
import org.mapstruct.Mapper; // Импортируем аннотацию @Mapper из MapStruct.
import org.mapstruct.Mapping; // Импортируем аннотацию @Mapping из MapStruct для настройки маппинга.
import org.mapstruct.MappingConstants; // Импортируем константы MapStruct.
import org.mapstruct.MappingTarget; // Импортируем аннотацию @MappingTarget для методов обновления.

import java.util.List; // Импортируем интерфейс List.
import java.util.stream.Collectors; // Импортируем Collectors для работы со стримами.

// Аннотация MapStruct: указывает, что это интерфейс маппера, генерирующий Spring компонент.
// `uses = {SwitchMapper.class}` не обязателен, если используем default-метод для маппинга ID.
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {SwitchMapper.class})
public interface SwitchDeviceMapper { // Объявляем публичный интерфейс SwitchDeviceMapper.

    // Entity -> DTO // Комментарий к секции маппинга Сущность -> DTO.
    @Mapping(source = "room.id", target = "roomId") // Мапим ID комнаты.
    @Mapping(source = "switches", target = "switchIds") // Мапим список Switch в список их ID, используя default-метод ниже.
    // Автомаппинг полей из SwitchDevice, DeviceBase, AbstractEntity, совпадающих с DTO по имени и типу.
    SwitchDeviceDto toDto(SwitchDevice entity); // Абстрактный метод. MapStruct сгенерирует реализацию.

    // DTO -> Entity // Комментарий к секции маппинга DTO -> Сущность.
    // Мапятся поля из DTO в соответствующие поля SwitchDevice/DeviceBase/AbstractEntity.
    @Mapping(target = "id", ignore = true) // Игнорируем `id`.
    @Mapping(target = "room", ignore = true) // Игнорируем `room`: связь устанавливается в сервисе.
    @Mapping(target = "switches", ignore = true) // Игнорируем `switches`: связь устанавливается в сервисе.
    @Mapping(target = "createdAt", ignore = true) // Игнорируем `createdAt`.
    @Mapping(target = "modifiedAt", ignore = true) // Игнорируем `modifiedAt`.
    @Mapping(target = "removed", ignore = true) // Игнорируем `isRemoved`.
    @Mapping(target = "removedAt", ignore = true) // Игнорируем `removedAt`.
    @Mapping(target = "deviceType", ignore = true) // Игнорируем унаследованное поле `deviceType`.
    @Mapping(target = "status", ignore = true) // Игнорируем унаследованное поле `status`.
    @Mapping(target = "firmwareVersion", ignore = true) // Игнорируем унаследованное поле `firmwareVersion`.
    @Mapping(target = "manufacturer", ignore = true) // Игнорируем унаследованное поле `manufacturer`.
    @Mapping(target = "model", ignore = true) // Игнорируем унаследованное поле `model`.
    @Mapping(target = "wiFiParameters", ignore = true) // Игнорируем унаследованное поле `wiFiParameters`.
    SwitchDevice toEntity(SwitchDeviceDto dto); // Абстрактный метод. MapStruct сгенерирует реализацию для создания новой сущности.

    // Вспомогательный метод для маппинга списка Switch в список ID // Комментарий к default-методу.
    default List<Long> mapSwitchesToSwitchIds(List<Switch> switches) { // Default-метод для преобразования списка Switch в список их ID.
        if (switches == null) { // Проверка на null.
            return null; // Возвращаем null, если список пуст.
        }
        return switches.stream() // Создаем стрим из списка Switch.
                .map(Switch::getId) // Для каждого элемента Switch получаем его ID.
                .collect(Collectors.toList()); // Собираем ID в новый список.
    }

    // Метод обновления существующей сущности SwitchDevice из SwitchDeviceDto // Комментарий к методу обновления.
    @Mapping(target = "id", ignore = true) // Игнорируем `id`.
    @Mapping(target = "room", ignore = true) // Игнорируем `room`.
    @Mapping(target = "switches", ignore = true) // Игнорируем `switches`.
    @Mapping(target = "createdAt", ignore = true) // Игнорируем `createdAt`.
    @Mapping(target = "modifiedAt", ignore = true) // Игнорируем `modifiedAt`.
    @Mapping(target = "removed", ignore = true) // Игнорируем `isRemoved`.
    @Mapping(target = "removedAt", ignore = true) // Игнорируем `removedAt`.
    @Mapping(target = "deviceType", ignore = true) // Игнорируем `deviceType`.
    @Mapping(target = "status", ignore = true) // Игнорируем `status`.
    @Mapping(target = "firmwareVersion", ignore = true) // Игнорируем `firmwareVersion`.
    @Mapping(target = "manufacturer", ignore = true) // Игнорируем `manufacturer`.
    @Mapping(target = "model", ignore = true) // Игнорируем `model`.
    @Mapping(target = "wiFiParameters", ignore = true) // Игнорируем `wiFiParameters`.
    // Аннотация `@MappingTarget` указывает MapStruct обновлять переданный объект `entity`.
    void updateFromDto(SwitchDeviceDto dto, @MappingTarget SwitchDevice entity); // Абстрактный метод обновления.
}