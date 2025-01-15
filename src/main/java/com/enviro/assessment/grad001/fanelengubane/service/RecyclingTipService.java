// src/main/java/com/enviro/assessment/grad001/fanelengubane/service/RecyclingTipService.java
package com.enviro.assessment.grad001.fanelengubane.service;

import com.enviro.assessment.grad001.fanelengubane.model.RecyclingTip;
import com.enviro.assessment.grad001.fanelengubane.repository.RecyclingTipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {

    private final RecyclingTipRepository repository;

    public RecyclingTipService(RecyclingTipRepository repository) {
        this.repository = repository;
    }

    public RecyclingTip save(RecyclingTip tip) {
        return repository.save(tip);
    }

    public List<RecyclingTip> findAll() {
        return repository.findAll();
    }

    public RecyclingTip findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Recycling tip not found"));
    }

    public RecyclingTip update(Long id, RecyclingTip updatedTip) {
        RecyclingTip existing = findById(id);
        existing.setTip(updatedTip.getTip());
        return repository.save(existing);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}