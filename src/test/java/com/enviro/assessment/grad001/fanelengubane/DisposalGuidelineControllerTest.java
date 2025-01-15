package com.enviro.assessment.grad001.fanelengubane;

import com.enviro.assessment.grad001.fanelengubane.model.DisposalGuideline;
import com.enviro.assessment.grad001.fanelengubane.repository.DisposalGuidelineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DisposalGuidelineControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private DisposalGuidelineRepository repository;

    @BeforeEach
    public void setup() {
        repository.deleteAll();
    }

    @Test
    public void testCreateDisposalGuideline() {
        DisposalGuideline guideline = new DisposalGuideline();
        guideline.setGuideline("Dispose of plastic in the blue bin.");

        ResponseEntity<DisposalGuideline> response = restTemplate.postForEntity("http://localhost:" + port + "/api/disposal-guidelines", guideline, DisposalGuideline.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(201);
        assertThat(response.getBody().getId()).isNotNull();
        assertThat(response.getBody().getGuideline()).isEqualTo("Dispose of plastic in the blue bin.");
    }

    @Test
    public void testGetAllDisposalGuidelines() {
        DisposalGuideline guideline = new DisposalGuideline();
        guideline.setGuideline("Dispose of plastic in the blue bin.");
        repository.save(guideline);

        ResponseEntity<DisposalGuideline[]> response = restTemplate.getForEntity("http://localhost:" + port + "/api/disposal-guidelines", DisposalGuideline[].class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(1);
        assertThat(response.getBody()[0].getGuideline()).isEqualTo("Dispose of plastic in the blue bin.");
    }

    @Test
    public void testGetDisposalGuidelineById() {
        DisposalGuideline guideline = new DisposalGuideline();
        guideline.setGuideline("Dispose of plastic in the blue bin.");
        DisposalGuideline savedGuideline = repository.save(guideline);

        ResponseEntity<DisposalGuideline> response = restTemplate.getForEntity("http://localhost:" + port + "/api/disposal-guidelines/" + savedGuideline.getId(), DisposalGuideline.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getGuideline()).isEqualTo("Dispose of plastic in the blue bin.");
    }

    @Test
    public void testUpdateDisposalGuideline() {
        DisposalGuideline guideline = new DisposalGuideline();
        guideline.setGuideline("Dispose of plastic in the blue bin.");
        DisposalGuideline savedGuideline = repository.save(guideline);

        DisposalGuideline updatedGuideline = new DisposalGuideline();
        updatedGuideline.setGuideline("Updated guideline");

        HttpEntity<DisposalGuideline> requestEntity = new HttpEntity<>(updatedGuideline);
        ResponseEntity<DisposalGuideline> response = restTemplate.exchange("http://localhost:" + port + "/api/disposal-guidelines/" + savedGuideline.getId(), HttpMethod.PUT, requestEntity, DisposalGuideline.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getGuideline()).isEqualTo("Updated guideline");
    }

    @Test
    public void testDeleteDisposalGuideline() {
        DisposalGuideline guideline = new DisposalGuideline();
        guideline.setGuideline("Dispose of plastic in the blue bin.");
        DisposalGuideline savedGuideline = repository.save(guideline);

        restTemplate.delete("http://localhost:" + port + "/api/disposal-guidelines/" + savedGuideline.getId());
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/api/disposal-guidelines/" + savedGuideline.getId(), String.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(404);
    }
}