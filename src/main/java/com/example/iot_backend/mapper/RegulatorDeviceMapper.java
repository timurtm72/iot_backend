package com.example.iot_backend.mapper; // Объявляем пакет, в котором находится этот интерфейс маппера.

import com.example.iot_backend.dto.RegulatorDeviceDto; // Импортируем класс RegulatorDeviceDto (DTO).
import com.example.iot_backend.model.device.RegulatorDevice; // Импортируем класс RegulatorDevice (сущность).
import com.example.iot_backend.model.initial.Relay; // Импортируем сущность Relay.
import com.example.iot_backend.model.initial.Sensor; // Импортируем сущность Sensor.
import com.example.iot_backend.model.initial.Switch; // Импортируем сущность Switch.
import org.mapstruct.Mapper; // Импортируем аннотацию @Mapper из MapStruct.
import org.mapstruct.Mapping; // Импортируем аннотацию @Mapping из MapStruct для настройки маппинга.
import org.mapstruct.MappingConstants; // Импортируем константы MapStruct.
import org.mapstruct.MappingTarget; // Импортируем аннотацию @MappingTarget для методов обновления.

import java.util.List; // Импортируем интерфейс List.
import java.util.stream.Collectors; // Импортируем Collectors для работы со стримами.

/**
 * Маппер для преобразования между сущностью RegulatorDevice и RegulatorDeviceDto. // JavaDoc, описывающий маппер.
 */
// Аннотация MapStruct: указывает, что это интерфейс маппера, генерирующий Spring компонент.
// `uses = {...}` здесь не обязательны, так как мы используем default-методы для маппинга списков в ID.
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {SwitchMapper.class, RelayMapper.class, SensorMapper.class}) // Можно оставить uses на случай, если понадобятся полные мапперы.
public interface RegulatorDeviceMapper { // Объявляем публичный интерфейс RegulatorDeviceMapper.

    // Entity -> DTO // Комментарий к секции маппинга Сущность -> DTO.
    @Mapping(source = "room.id", target = "roomId") // Мапим ID комнаты.
    @Mapping(source = "switches", target = "switchIds") // Мапим список Switch в список их ID, используя default-метод ниже.
    @Mapping(source = "relays", target = "relayIds")   // Мапим список Relay в список их ID, используя default-метод ниже.
    @Mapping(source = "sensors", target = "sensorIds")  // Мапим список Sensor в список их ID, используя default-метод ниже.
    // Автомаппинг полей из RegulatorDevice, RegulatorDeviceBase, AbstractEntity, совпадающих с DTO по имени и типу.
    RegulatorDeviceDto toDto(RegulatorDevice entity); // Абстрактный метод. MapStruct сгенерирует реализацию.

    // DTO -> Entity // Комментарий к секции маппинга DTO -> Сущность.
    // Мапятся поля из DTO в соответствующие поля RegulatorDevice/RegulatorDeviceBase/AbstractEntity.
    @Mapping(target = "id", ignore = true) // Игнорируем `id`.
    @Mapping(target = "room", ignore = true) // Игнорируем `room`: связь устанавливается в сервисе.
    @Mapping(target = "switches", ignore = true) // Игнорируем `switches`: связь устанавливается в сервисе.
    @Mapping(target = "relays", ignore = true) // Игнорируем `relays`: связь устанавливается в сервисе.
    @Mapping(target = "sensors", ignore = true) // Игнорируем `sensors`: связь устанавливается в сервисе.
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
    RegulatorDevice toEntity(RegulatorDeviceDto dto); // Абстрактный метод. MapStruct сгенерирует реализацию для создания новой сущности.

    // Вспомогательные методы для маппинга списков сущностей в списки ID // Комментарий к секции default-методов.
    default List<Long> mapSwitchesToSwitchIds(List<Switch> switches) { // Default-метод для преобразования списка Switch в список их ID.
        if (switches == null) { // Проверка на null.
            return null; // Возвращаем null, если список пуст.
        }
        return switches.stream() // Создаем стрим из списка Switch.
                .map(Switch::getId) // Для каждого элемента Switch получаем его ID.
                .collect(Collectors.toList()); // Собираем ID в новый список.
    }

    default List<Long> mapRelaysToRelayIds(List<Relay> relays) { // Default-метод для преобразования списка Relay в список их ID.
        if (relays == null) { // Проверка на null.
            return null; // Возвращаем null, если список пуст.
        }
        return relays.stream() // Создаем стрим из списка Relay.
                .map(Relay::getId) // Для каждого элемента Relay получаем его ID.
                .collect(Collectors.toList()); // Собираем ID в новый список.
    }

    default List<Long> mapSensorsToSensorIds(List<Sensor> sensors) { // Default-метод для преобразования списка Sensor в список их ID.
        if (sensors == null) { // Проверка на null.
            return null; // Возвращаем null, если список пуст.
        }
        return sensors.stream() // Создаем стрим из списка Sensor.
                .map(Sensor::getId) // Для каждого элемента Sensor получаем его ID.
                .collect(Collectors.toList()); // Собираем ID в новый список.
    }

    // Метод обновления существующей сущности RegulatorDevice из RegulatorDeviceDto // Комментарий к методу обновления.
    @Mapping(target = "id", ignore = true) // Игнорируем `id`.
    @Mapping(target = "room", ignore = true) // Игнорируем `room`.
    @Mapping(target = "switches", ignore = true) // Игнорируем `switches`.
    @Mapping(target = "relays", ignore = true) // Игнорируем `relays`.
    @Mapping(target = "sensors", ignore = true) // Игнорируем `sensors`.
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
    void updateFromDto(RegulatorDeviceDto dto, @MappingTarget RegulatorDevice entity); // Абстрактный метод обновления.
}