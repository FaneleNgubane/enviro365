package com.enviro.assessment.grad001.fanelengubane.controller;

import com.enviro.assessment.grad001.fanelengubane.model.WasteCategory;
import com.enviro.assessment.grad001.fanelengubane.service.WasteCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    private final WasteCategoryService service;

    public WasteCategoryController(WasteCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WasteCategory> create(@Validated @RequestBody WasteCategory wasteCategory) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(wasteCategory));
    }

    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> update(@PathVariable Long id, @Validated @RequestBody WasteCategory updatedCategory) {
        return ResponseEntity.ok(service.update(id, updatedCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
