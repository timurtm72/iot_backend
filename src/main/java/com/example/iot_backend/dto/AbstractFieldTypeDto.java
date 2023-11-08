package com.example.iot_backend.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AbstractFieldTypeDto  <Value>  implements Serializable {
    private Long id;
    private LocalDateTime timeStamp;
    private Value value;

    @PrePersist
    public void toCreate(){
        this.setTimeStamp(LocalDateTime.now());
    }
}
