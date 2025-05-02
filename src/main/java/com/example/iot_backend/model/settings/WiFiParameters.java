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

    @Column(name = "security_type")
    private String securityType;

    @Column(name = "static_ip", nullable = true)
    private String staticIp;

    @Column(name = "subnet_mask", nullable = true)
    private String subnetMask;

    @Column(name = "gateway", nullable = true)
    private String gateway;

    @Column(name = "dns1", nullable = true)
    private String dns1;

    @Column(name = "dns2", nullable = true)
    private String dns2;
}
