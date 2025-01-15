package com.enviro.assessment.grad001.fanelengubane;

import com.enviro.assessment.grad001.fanelengubane.model.WasteCategory;
import com.enviro.assessment.grad001.fanelengubane.repository.WasteCategoryRepository;
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
public class WasteCategoryControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WasteCategoryRepository repository;

    @BeforeEach
    public void setup() {
        repository.deleteAll();
    }

    @Test
    public void testCreateWasteCategory() {
        WasteCategory wasteCategory = new WasteCategory();
        wasteCategory.setName("Plastic");
        wasteCategory.setDescription("Plastic waste");

        ResponseEntity<WasteCategory> response = restTemplate.postForEntity("http://localhost:" + port + "/api/waste-categories", wasteCategory, WasteCategory.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(201);
        assertThat(response.getBody().getId()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("Plastic");
        assertThat(response.getBody().getDescription()).isEqualTo("Plastic waste");
    }

    @Test
    public void testGetAllWasteCategories() {
        WasteCategory wasteCategory = new WasteCategory();
        wasteCategory.setName("Plastic");
        wasteCategory.setDescription("Plastic waste");
        repository.save(wasteCategory);

        ResponseEntity<WasteCategory[]> response = restTemplate.getForEntity("http://localhost:" + port + "/api/waste-categories", WasteCategory[].class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(1);
        assertThat(response.getBody()[0].getName()).isEqualTo("Plastic");
        assertThat(response.getBody()[0].getDescription()).isEqualTo("Plastic waste");
    }

    @Test
    public void testGetWasteCategoryById() {
        WasteCategory wasteCategory = new WasteCategory();
        wasteCategory.setName("Plastic");
        wasteCategory.setDescription("Plastic waste");
        WasteCategory savedCategory = repository.save(wasteCategory);

        ResponseEntity<WasteCategory> response = restTemplate.getForEntity("http://localhost:" + port + "/api/waste-categories/" + savedCategory.getId(), WasteCategory.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getName()).isEqualTo("Plastic");
        assertThat(response.getBody().getDescription()).isEqualTo("Plastic waste");
    }

    @Test
    public void testUpdateWasteCategory() {
        WasteCategory wasteCategory = new WasteCategory();
        wasteCategory.setName("Plastic");
        wasteCategory.setDescription("Plastic waste");
        WasteCategory savedCategory = repository.save(wasteCategory);

        WasteCategory updatedCategory = new WasteCategory();
        updatedCategory.setName("Updated Plastic");
        updatedCategory.setDescription("Updated description");

        HttpEntity<WasteCategory> requestEntity = new HttpEntity<>(updatedCategory);
        ResponseEntity<WasteCategory> response = restTemplate.exchange("http://localhost:" + port + "/api/waste-categories/" + savedCategory.getId(), HttpMethod.PUT, requestEntity, WasteCategory.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getName()).isEqualTo("Updated Plastic");
        assertThat(response.getBody().getDescription()).isEqualTo("Updated description");
    }

    @Test
    public void testDeleteWasteCategory() {
        WasteCategory wasteCategory = new WasteCategory();
        wasteCategory.setName("Plastic");
        wasteCategory.setDescription("Plastic waste");
        WasteCategory savedCategory = repository.save(wasteCategory);

        restTemplate.delete("http://localhost:" + port + "/api/waste-categories/" + savedCategory.getId());
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/api/waste-categories/" + savedCategory.getId(), String.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(404);
    }
}