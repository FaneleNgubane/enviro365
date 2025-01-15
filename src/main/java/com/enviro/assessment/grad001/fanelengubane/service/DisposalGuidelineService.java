package com.enviro.assessment.grad001.fanelengubane.service;

import com.enviro.assessment.grad001.fanelengubane.model.DisposalGuideline;
import com.enviro.assessment.grad001.fanelengubane.repository.DisposalGuidelineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing disposal guidelines.
 * This class contains business logic for creating, retrieving, updating, and deleting disposal guidelines.
 */
@Service
public class DisposalGuidelineService {

    private final DisposalGuidelineRepository repository;

    /**
     * Constructor to inject the DisposalGuidelineRepository dependency.
     *
     * @param repository the DisposalGuidelineRepository to be injected
     */
    public DisposalGuidelineService(DisposalGuidelineRepository repository) {
        this.repository = repository;
    }

    /**
     * Saves a new disposal guideline or updates an existing one.
     *
     * @param guideline the disposal guideline to be saved
     * @return the saved disposal guideline
     */
    public DisposalGuideline save(DisposalGuideline guideline) {
        return repository.save(guideline);
    }

    /**
     * Retrieves all disposal guidelines.
     *
     * @return a list of all disposal guidelines
     */
    public List<DisposalGuideline> findAll() {
        return repository.findAll();
    }

    /**
     * Retrieves a disposal guideline by its ID.
     *
     * @param id the ID of the disposal guideline to be retrieved
     * @return the retrieved disposal guideline
     * @throws RuntimeException if the disposal guideline is not found
     */
    public DisposalGuideline findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Disposal guideline not found"));
    }

    /**
     * Updates an existing disposal guideline.
     *
     * @param id the ID of the disposal guideline to be updated
     * @param updatedGuideline the updated disposal guideline data
     * @return the updated disposal guideline
     */
    public DisposalGuideline update(Long id, DisposalGuideline updatedGuideline) {
        DisposalGuideline existing = findById(id);
        existing.setGuideline(updatedGuideline.getGuideline());
        return repository.save(existing);
    }

    /**
     * Deletes a disposal guideline by its ID.
     *
     * @param id the ID of the disposal guideline to be deleted
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}