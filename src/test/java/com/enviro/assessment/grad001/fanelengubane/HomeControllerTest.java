package com.enviro.assessment.grad001.fanelengubane;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHome() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/", String.class);
        assertThat(response.getBody()).isEqualTo("Welcome to Enviro365 API!");
    }

    @Test
    public void testInfo() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/info", String.class);
        assertThat(response.getBody()).isEqualTo("Enviro365 API provides RESTful endpoints for managing waste categories, disposal guidelines, and recycling tips.");
    }

    @Test
    public void testStatus() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/status", String.class);
        assertThat(response.getBody()).isEqualTo("Enviro365 API is running.");
    }
}