package com.itzone.itzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@SpringBootApplication
public class ItZoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItZoneApplication.class, args);
    }

}
