package com.example.iot_backend.utils;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Класс для представления ответа на запросы API.
 * Содержит сообщение и временную метку события.
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    /**
     * Сообщение ответа
     */
    private String message;
    
    /**
     * Временная метка создания ответа
     */
    private LocalDateTime timestamp;
}
