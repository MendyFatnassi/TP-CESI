package org.example.tp2gestent;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;


@Configuration
@ConfigurationProperties(prefix = "com.tp2gestent.webapp")
@Data
public class CustomProperties {

    private String apiUrl;

}