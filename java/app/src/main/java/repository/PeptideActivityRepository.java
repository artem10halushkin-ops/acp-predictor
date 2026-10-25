package repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import entity.Peptide_Activity;

@Repository
public interface PeptideActivityRepository extends JpaRepository<Peptide_Activity, Long> {
}
