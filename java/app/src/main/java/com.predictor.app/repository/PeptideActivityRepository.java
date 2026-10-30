package com.predictor.app.repository;

import com.predictor.app.entity.Peptide_Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PeptideActivityRepository extends JpaRepository<Peptide_Activity, Long> {
}
