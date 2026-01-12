package com.github.lowkkid.lodgecore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LodgeCoreBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LodgeCoreBackendApplication.class, args);
    }

}
