package com.flex.BackendAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The start point of the backend server
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // Run a separate thread to connect a singleton to database.

        // Initializes the backend server and opens the connection for API calls.
        SpringApplication.run(Main.class, args);
    }
}
