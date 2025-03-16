package com.example.iot_backend.model.settings;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class WiFiParameters {
    @Column(name = "ssid", nullable = false)
    private String ssid;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "security_type", nullable = false)
    private String securityType;
}
