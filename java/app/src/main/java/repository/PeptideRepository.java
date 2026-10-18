package repository;

import entity.Peptide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeptideRepository extends JpaRepository<Peptide, Long> {
}
