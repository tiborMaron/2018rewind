package com.codecool.google_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class GoogleServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(GoogleServiceApp.class, args);
    }
}
