package com.example.iot_backend.dto; // Пакет для DTO

import lombok.AllArgsConstructor; // Аннотация Lombok для генерации конструктора со всеми аргументами
import lombok.Data; // Аннотация Lombok: объединяет @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
import lombok.NoArgsConstructor; // Аннотация Lombok для генерации конструктора без аргументов

/**
 * DTO для параметров WiFi.
 * Используется для передачи данных о настройках WiFi между слоями и в API ответах.
 */
@Data // Генерирует геттеры, сеттеры, equals, hashCode, toString
@NoArgsConstructor // Генерирует конструктор без аргументов
@AllArgsConstructor // Генерирует конструктор со всеми аргументами
public class WiFiParametersDto {
    /**
     * Имя сети WiFi (SSID).
     */
    private String ssid; // Поле для хранения SSID

    /**
     * Пароль для сети WiFi.
     * ВАЖНО: Будьте осторожны при передаче паролей в DTO. Возможно, его следует исключать из некоторых ответов.
     */
    private String password; // Поле для хранения пароля

    /**
     * Статический IP-адрес устройства (если используется).
     */
    private String staticIp; // Поле для хранения статического IP

    /**
     * Маска подсети (если используется статический IP).
     */
    private String subnetMask; // Поле для хранения маски подсети

    /**
     * IP-адрес шлюза по умолчанию (если используется статический IP).
     */
    private String gateway; // Поле для хранения IP шлюза

    /**
     * IP-адрес основного DNS-сервера (если используется статический IP).
     */
    private String dns1; // Поле для хранения основного DNS

    /**
     * IP-адрес дополнительного DNS-сервера (если используется статический IP).
     */
    private String dns2; // Поле для хранения дополнительного DNS
}