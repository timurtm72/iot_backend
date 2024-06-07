package com.example.iot_backend.enums;

public enum FieldTypes {
    FLOAT_TYPE("Тип Float"),
    LONG_TYPE("Тип Long"),
    BOOL_TYPE("Тип Boolean");
    private String name;
    FieldTypes(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
