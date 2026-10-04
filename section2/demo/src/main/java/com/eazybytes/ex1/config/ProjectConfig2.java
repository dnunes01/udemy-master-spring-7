package com.eazybytes.ex1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig2 {

    @Bean
    String helloWorld() {
        return "Hello World!";
    }

    @Bean
    Integer luckyNumber() {
        return 16;
    }
}
