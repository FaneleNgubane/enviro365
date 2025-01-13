package com.enviro.assessment.grad001.fanelengubane.controller;

import com.enviro.assessment.grad001.fanelengubane.model.WasteCategory;
import com.enviro.assessment.grad001.fanelengubane.service.WasteCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing waste categories.
 * Provides endpoints for creating, retrieving, updating, and deleting waste categories.
 */
@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    private final WasteCategoryService service;

    /**
     * Constructor to inject the WasteCategoryService dependency.
     *
     * @param service the WasteCategoryService to be injected
     */
    public WasteCategoryController(WasteCategoryService service) {
        this.service = service;
    }

    /**
     * Endpoint to create a new waste category.
     *
     * @param wasteCategory the waste category to be created
     * @return ResponseEntity containing the created waste category and HTTP status CREATED
     */
    @PostMapping
    public ResponseEntity<WasteCategory> create(@Validated @RequestBody WasteCategory wasteCategory) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(wasteCategory));
    }

    /**
     * Endpoint to retrieve all waste categories.
     *
     * @return ResponseEntity containing the list of all waste categories and HTTP status OK
     */
    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Endpoint to retrieve a waste category by its ID.
     *
     * @param id the ID of the waste category to be retrieved
     * @return ResponseEntity containing the waste category and HTTP status OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * Endpoint to update an existing waste category.
     *
     * @param id the ID of the waste category to be updated
     * @param updatedCategory the updated waste category data
     * @return ResponseEntity containing the updated waste category and HTTP status OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> update(@PathVariable Long id, @Validated @RequestBody WasteCategory updatedCategory) {
        return ResponseEntity.ok(service.update(id, updatedCategory));
    }

    /**
     * Endpoint to delete a waste category by its ID.
     *
     * @param id the ID of the waste category to be deleted
     * @return ResponseEntity with HTTP status NO_CONTENT
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}