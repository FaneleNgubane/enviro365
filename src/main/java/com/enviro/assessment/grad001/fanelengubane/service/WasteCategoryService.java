package com.enviro.assessment.grad001.fanelengubane.service;

import com.enviro.assessment.grad001.fanelengubane.model.WasteCategory;
import com.enviro.assessment.grad001.fanelengubane.repository.WasteCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing waste categories.
 * This class contains business logic for creating, retrieving, updating, and deleting waste categories.
 */
@Service
public class WasteCategoryService {

    private final WasteCategoryRepository repository;

    /**
     * Constructor to inject the WasteCategoryRepository dependency.
     *
     * @param repository the WasteCategoryRepository to be injected
     */
    public WasteCategoryService(WasteCategoryRepository repository) {
        this.repository = repository;
    }

    /**
     * Saves a new waste category or updates an existing one.
     *
     * @param wasteCategory the waste category to be saved
     * @return the saved waste category
     */
    public WasteCategory save(WasteCategory wasteCategory) {
        return repository.save(wasteCategory);
    }

    /**
     * Retrieves all waste categories.
     *
     * @return a list of all waste categories
     */
    public List<WasteCategory> findAll() {
        return repository.findAll();
    }

    /**
     * Retrieves a waste category by its ID.
     *
     * @param id the ID of the waste category to be retrieved
     * @return the retrieved waste category
     * @throws RuntimeException if the waste category is not found
     */
    public WasteCategory findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Waste category not found"));
    }

    /**
     * Updates an existing waste category.
     *
     * @param id the ID of the waste category to be updated
     * @param updatedCategory the updated waste category data
     * @return the updated waste category
     */
    public WasteCategory update(Long id, WasteCategory updatedCategory) {
        WasteCategory existing = findById(id);
        existing.setName(updatedCategory.getName());
        existing.setDescription(updatedCategory.getDescription());
        return repository.save(existing);
    }

    /**
     * Deletes a waste category by its ID.
     *
     * @param id the ID of the waste category to be deleted
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}