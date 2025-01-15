package com.enviro.assessment.grad001.fanelengubane;

import com.enviro.assessment.grad001.fanelengubane.model.RecyclingTip;
import com.enviro.assessment.grad001.fanelengubane.repository.RecyclingTipRepository;
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
public class RecyclingTipControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RecyclingTipRepository repository;

    @BeforeEach
    public void setup() {
        repository.deleteAll();
    }

    @Test
    public void testCreateRecyclingTip() {
        RecyclingTip tip = new RecyclingTip();
        tip.setTip("Rinse plastic containers before recycling.");

        ResponseEntity<RecyclingTip> response = restTemplate.postForEntity("http://localhost:" + port + "/api/recycling-tips", tip, RecyclingTip.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(201);
        assertThat(response.getBody().getId()).isNotNull();
        assertThat(response.getBody().getTip()).isEqualTo("Rinse plastic containers before recycling.");
    }

    @Test
    public void testGetAllRecyclingTips() {
        RecyclingTip tip = new RecyclingTip();
        tip.setTip("Rinse plastic containers before recycling.");
        repository.save(tip);

        ResponseEntity<RecyclingTip[]> response = restTemplate.getForEntity("http://localhost:" + port + "/api/recycling-tips", RecyclingTip[].class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(1);
        assertThat(response.getBody()[0].getTip()).isEqualTo("Rinse plastic containers before recycling.");
    }

    @Test
    public void testGetRecyclingTipById() {
        RecyclingTip tip = new RecyclingTip();
        tip.setTip("Rinse plastic containers before recycling.");
        RecyclingTip savedTip = repository.save(tip);

        ResponseEntity<RecyclingTip> response = restTemplate.getForEntity("http://localhost:" + port + "/api/recycling-tips/" + savedTip.getId(), RecyclingTip.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getTip()).isEqualTo("Rinse plastic containers before recycling.");
    }

    @Test
    public void testUpdateRecyclingTip() {
        RecyclingTip tip = new RecyclingTip();
        tip.setTip("Rinse plastic containers before recycling.");
        RecyclingTip savedTip = repository.save(tip);

        RecyclingTip updatedTip = new RecyclingTip();
        updatedTip.setTip("Updated tip");

        HttpEntity<RecyclingTip> requestEntity = new HttpEntity<>(updatedTip);
        ResponseEntity<RecyclingTip> response = restTemplate.exchange("http://localhost:" + port + "/api/recycling-tips/" + savedTip.getId(), HttpMethod.PUT, requestEntity, RecyclingTip.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getTip()).isEqualTo("Updated tip");
    }

    @Test
    public void testDeleteRecyclingTip() {
        RecyclingTip tip = new RecyclingTip();
        tip.setTip("Rinse plastic containers before recycling.");
        RecyclingTip savedTip = repository.save(tip);

        restTemplate.delete("http://localhost:" + port + "/api/recycling-tips/" + savedTip.getId());
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/api/recycling-tips/" + savedTip.getId(), String.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(404);
    }
}