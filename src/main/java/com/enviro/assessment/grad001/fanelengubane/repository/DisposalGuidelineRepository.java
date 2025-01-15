package com.enviro.assessment.grad001.fanelengubane.repository;

import com.enviro.assessment.grad001.fanelengubane.model.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for DisposalGuideline entities.
 * Extends JpaRepository to provide CRUD operations.
 */
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {
}