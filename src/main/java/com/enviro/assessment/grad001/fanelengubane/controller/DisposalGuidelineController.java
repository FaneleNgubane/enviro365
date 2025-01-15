// src/main/java/com/enviro/assessment/grad001/fanelengubane/controller/DisposalGuidelineController.java
package com.enviro.assessment.grad001.fanelengubane.controller;

import com.enviro.assessment.grad001.fanelengubane.model.DisposalGuideline;
import com.enviro.assessment.grad001.fanelengubane.service.DisposalGuidelineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    private final DisposalGuidelineService service;

    public DisposalGuidelineController(DisposalGuidelineService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DisposalGuideline> create(@Validated @RequestBody DisposalGuideline guideline) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(guideline));
    }

    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> update(@PathVariable Long id, @Validated @RequestBody DisposalGuideline updatedGuideline) {
        return ResponseEntity.ok(service.update(id, updatedGuideline));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}