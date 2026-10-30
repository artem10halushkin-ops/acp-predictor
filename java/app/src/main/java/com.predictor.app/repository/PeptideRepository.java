package com.predictor.app.repository;


import com.predictor.app.entity.Peptide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeptideRepository extends JpaRepository<Peptide, Long> {
    Optional<Peptide> findBySequence(String sequence);
}
