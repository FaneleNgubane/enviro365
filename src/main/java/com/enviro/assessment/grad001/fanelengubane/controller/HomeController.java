// src/main/java/com/enviro/assessment/grad001/fanelengubane/controller/HomeController.java
package com.enviro.assessment.grad001.fanelengubane.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController to handle requests to the root URL.
 * This controller provides a simple welcome message and can be extended to provide additional
 * information about the application, such as API documentation links or status checks.
 */
@RestController
public class HomeController {

    /**
     * Handles GET requests to the root URL ("/").
     * This endpoint provides a welcome message to users accessing the API.
     *
     * @return A welcome message.
     */
    @GetMapping("/")
    public String home() {
        return "Welcome to Enviro365 API!";
    }

    /**
     * Handles GET requests to the "/info" URL.
     * This endpoint provides basic information about the application, such as its purpose and available resources.
     *
     * @return Information about the application.
     */
    @GetMapping("/info")
    public String info() {
        return "Enviro365 API provides RESTful endpoints for managing waste categories, disposal guidelines, and recycling tips.";
    }

    /**
     * Handles GET requests to the "/docs" URL.
     * This endpoint provides a link to the API documentation.
     *
     * @return A link to the API documentation.
     */
    @GetMapping("/docs")
    public String docs() {
        return "API documentation is available at: /swagger-ui.html";
    }

    /**
     * Handles GET requests to the "/status" URL.
     * This endpoint provides a simple status check for the application.
     *
     * @return The status of the application.
     */
    @GetMapping("/status")
    public String status() {
        return "Enviro365 API is running.";
    }
}