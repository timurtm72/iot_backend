// Объявление пакета, в котором находится класс
package com.example.iot_backend.model.base;

// Импорт перечисления InOutType из указанного пакета
import com.example.iot_backend.enums.InOutType;
// Импорт аннотаций JPA (Java Persistence API) из пакета jakarta.persistence
import jakarta.persistence.*;
// Импорт аннотаций Lombok для автоматической генерации кода
import lombok.*;

// Импорт интерфейса Serializable для возможности сериализации объектов класса
import java.io.Serializable;

/**
 * Базовый абстрактный класс для устройств с типом входа/выхода и именем значения.
 * Наследуется от AbstractEntity.
 * Этот класс не будет представлен отдельной таблицей в базе данных,
 * его поля будут включены в таблицы классов-наследников.
 */
@MappedSuperclass // Указывает, что это суперкласс, поля которого будут наследоваться сущностями
@EqualsAndHashCode(callSuper = true) // Генерирует методы equals и hashCode, включая поля суперкласса
@NoArgsConstructor // Генерирует конструктор без аргументов
@AllArgsConstructor // Генерирует конструктор со всеми полями класса в качестве аргументов
@Getter // Генерирует геттеры для всех полей
@Setter // Генерирует сеттеры для всех полей
@ToString(callSuper = true) // Генерирует метод toString, включая поля суперкласса
public abstract class DeviceBase extends AbstractEntity implements Serializable { // Объявление абстрактного класса DeviceBase, наследующего AbstractEntity и реализующего Serializable

    /**
     * Тип устройства (вход/выход).
     * Определяет, является ли устройство источником данных (вход) или исполнителем (выход).
     */
    @Enumerated(EnumType.STRING) // Указывает, что перечисление должно храниться в базе данных как строка
    @Column(name = "in_out_type", nullable = false) // Определяет маппинг поля на колонку "in_out_type" в БД, которая не может быть null
    private InOutType inOutType; // Поле для хранения типа устройства (вход/выход)

    /**
     * Название измеряемой величины или контролируемого параметра.
     * Например, "Температура", "Влажность", "Состояние реле".
     */
    @Column(name = "value_name", nullable = false) // Определяет маппинг поля на колонку "value_name" в БД, которая не может быть null
    private String valueName; // Поле для хранения названия значения
}