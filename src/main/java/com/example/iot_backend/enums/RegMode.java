package com.example.iot_backend.enums;

public enum RegMode {
    HEAT_MODE("Режим нагрева"),
    COOL_MODE("Режим охлаждения");
    private String name;
    RegMode(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}