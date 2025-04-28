package com.example.iot_backend.model.initial;


import com.example.iot_backend.model.data.BitData; // Импорт класса для хранения бинарных данных
import jakarta.persistence.*; // Импорт аннотаций JPA
import lombok.*; // Импорт аннотаций Lombok
import org.hibernate.annotations.SQLDelete; // Импорт аннотации для мягкого удаления
import org.hibernate.annotations.Where; // Импорт аннотации для фильтрации удаленных записей

import java.util.ArrayList; // Импорт класса ArrayList
import java.util.List; // Импорт интерфейса List

@EqualsAndHashCode // Генерирует методы equals и hashCode
@NoArgsConstructor // Генерирует конструктор без аргументов
@AllArgsConstructor // Генерирует конструктор со всеми полями
@Getter // Генерирует геттеры
@Setter // Генерирует сеттеры
@ToString // Генерирует метод toString
@Entity // Указывает, что класс является сущностью JPA
@Table(name = "switch") // Задает имя таблицы в базе данных как "switch" (исправлено с switch_device)
@SQLDelete(sql = "UPDATE switch SET is_removed = true WHERE id = ?") // Определяет SQL-запрос для мягкого удаления
@Where(clause = "is_removed=false") // Фильтрует записи, исключая помеченные как удаленные
public class Switch {
    /**
     * Уникальный идентификатор переключателя
     */
    @Id // Указывает, что это поле является первичным ключом
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Указывает, что значение ID генерируется базой данных автоматически
    private Long id; // Поле для хранения идентификатора

    /**
     * Флаг мягкого удаления
     */
    @Column(name = "is_removed", nullable = false) // Маппинг на колонку is_removed, не может быть null
    private boolean isRemoved = Boolean.FALSE; // Поле для флага мягкого удаления, по умолчанию false

    /**
     * Коллекция значений состояния переключателя (включено/выключено) с временными метками.
     * Использует ленивую загрузку для оптимизации производительности.
     * Хранится в отдельной таблице "switch_values".
     */
    @ElementCollection(fetch = FetchType.LAZY) // Определяет коллекцию встраиваемых объектов с ленивой загрузкой
    @CollectionTable(
        name = "switch_values", // Имя таблицы для хранения коллекции
        joinColumns = @JoinColumn(name = "switch_id") // Имя колонки для связи с таблицей switch (исправлено с switch_device_id)
    )
    @OrderBy("timestamp DESC") // Сортировка значений по временной метке в порядке убывания (последние первыми)
    private List<BitData> switchValues = new ArrayList<>(); // Поле для хранения списка значений переключателя, инициализировано пустым списком
}