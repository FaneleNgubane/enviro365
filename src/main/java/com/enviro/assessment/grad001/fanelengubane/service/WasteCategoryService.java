package com.enviro.assessment.grad001.fanelengubane.service;

import com.enviro.assessment.grad001.fanelengubane.model.WasteCategory;
import com.enviro.assessment.grad001.fanelengubane.repository.WasteCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {

    private final WasteCategoryRepository repository;

    public WasteCategoryService(WasteCategoryRepository repository) {
        this.repository = repository;
    }

    public WasteCategory save(WasteCategory wasteCategory) {
        return repository.save(wasteCategory);
    }

    public List<WasteCategory> findAll() {
        return repository.findAll();
    }

    public WasteCategory findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Waste category not found"));
    }

    public WasteCategory update(Long id, WasteCategory updatedCategory) {
        WasteCategory existing = findById(id);
        existing.setName(updatedCategory.getName());
        existing.setDescription(updatedCategory.getDescription());
        return repository.save(existing);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
