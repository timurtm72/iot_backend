package com.example.iot_backend.enums;

public enum Role {
    USER_ROLE("Пользователь"),
    ADMIN_ROLE("Администратор");
    private String name;
    Role(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
