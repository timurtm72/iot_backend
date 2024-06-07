package com.example.iot_backend;

import com.example.iot_backend.model.device.RelayDevice;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IotBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(IotBackendApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
