package com.example.iot_backend.enums;

/**
 * Перечисление, определяющее тип устройства по его назначению
 */
public enum DeviceType {
    SENSOR_DEVICE("Устройство датчиков"),
    RELAY_DEVICE("Устройство реле"),
    SWITCH_DEVICE("Устройство переключателей"),
    REGULATOR_DEVICE("Регулятор");


    private String name;
    
    DeviceType(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
} 