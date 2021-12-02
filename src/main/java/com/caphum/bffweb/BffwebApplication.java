package com.caphum.bffweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BffwebApplication {
    public static final String URL_API = "http://localhost:8084/API";

    public static void main(String[] args) {
        SpringApplication.run(BffwebApplication.class, args);
    }

}
