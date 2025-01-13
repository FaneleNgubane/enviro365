package com.enviro.assessment.grad001.fanelengubane.repository;

import com.enviro.assessment.grad001.fanelengubane.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {

    /**
     * Finds waste categories by their name.
     *
     * @param name the name of the waste category
     * @return a list of waste categories with the specified name
     */
    List<WasteCategory> findByName(String name);
}