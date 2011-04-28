package pl.michalorman.springdata.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.michalorman.springdata.jpa.entity.Applicant;

public interface ApplicantsRepository extends JpaRepository<Applicant, Long> {
}
