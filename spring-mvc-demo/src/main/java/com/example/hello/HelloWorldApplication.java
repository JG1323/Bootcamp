package com.example.hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration

public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run1(HelloWorldApplication.class, args);
    }

    @Bean
    public CommandLineRunner run1() {
        return args -> {
            System.out.println("Hello, World!");
        };
    }
}