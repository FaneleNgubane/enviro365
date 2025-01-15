// src/main/java/com/enviro/assessment/grad001/fanelengubane/controller/RecyclingTipController.java
package com.enviro.assessment.grad001.fanelengubane.controller;

import com.enviro.assessment.grad001.fanelengubane.model.RecyclingTip;
import com.enviro.assessment.grad001.fanelengubane.service.RecyclingTipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    private final RecyclingTipService service;

    public RecyclingTipController(RecyclingTipService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RecyclingTip> create(@Validated @RequestBody RecyclingTip tip) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(tip));
    }

    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> update(@PathVariable Long id, @Validated @RequestBody RecyclingTip updatedTip) {
        return ResponseEntity.ok(service.update(id, updatedTip));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}