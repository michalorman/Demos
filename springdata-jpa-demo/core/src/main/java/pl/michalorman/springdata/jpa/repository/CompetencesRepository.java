package pl.michalorman.springdata.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.michalorman.springdata.jpa.entity.Competence;

import java.util.List;

public interface CompetencesRepository extends JpaRepository<Competence, Long> {
    List<Competence> findByNameLike(String name);
}
