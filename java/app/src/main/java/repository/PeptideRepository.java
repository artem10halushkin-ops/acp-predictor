package repository;

import entity.Peptide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface PeptideRepository extends JpaRepository<Peptide, Long> {
    Optional<Peptide> findBySequence(String sequence);
}
