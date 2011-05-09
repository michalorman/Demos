package pl.michalorman.springdata.jpa.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryDslPredicateExecutor;
import pl.michalorman.springdata.jpa.entity.Applicant;
import pl.michalorman.springdata.jpa.entity.Competence;

import java.util.List;

public interface ApplicantsRepository extends JpaRepository<Applicant, Long>, QueryDslPredicateExecutor<Applicant> {
    List<Applicant> findAll(Specification<Applicant> applicantSpecification);

    List<Applicant> findWithCompetence(Competence competence);
}
