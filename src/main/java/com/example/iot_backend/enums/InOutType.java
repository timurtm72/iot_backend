package com.example.iot_backend.enums;

public enum InOutType {
    INPUT("Вход"),
    OUTPUT("Выход"),
    BOTH("Вход/Выход");

    private String name;
    
    InOutType(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
} 