package com.example.iot_backend.dto;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@MappedSuperclass
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AbstractFieldTypeDto  <Value>  implements Serializable {
    private Long id;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime timeStamp;
    @NotEmpty(message = "Значение не можеть быть пустым")
    private Value value;
}
