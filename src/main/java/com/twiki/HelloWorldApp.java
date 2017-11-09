package com.twiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
public final class HelloWorldApp {
    private HelloWorldApp() {
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloWorldApp.class, args);
    }
}
