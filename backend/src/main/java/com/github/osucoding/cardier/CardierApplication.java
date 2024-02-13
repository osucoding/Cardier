package com.github.osucoding.cardier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CardierApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardierApplication.class, args);
    }
}
