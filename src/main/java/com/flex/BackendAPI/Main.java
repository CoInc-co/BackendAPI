package com.flex.BackendAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // Run a separate thread to connect a singleton to database.

        SpringApplication.run(Main.class, args);
    }
}
