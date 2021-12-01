package com.ofw.ofw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OfwApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfwApplication.class, args);
    }
}
