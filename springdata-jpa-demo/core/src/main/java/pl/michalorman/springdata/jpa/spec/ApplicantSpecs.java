package pl.michalorman.springdata.jpa.spec;

import org.springframework.data.jpa.domain.Specification;
import pl.michalorman.springdata.jpa.entity.Applicant;
import pl.michalorman.springdata.jpa.entity.Applicant_;
import pl.michalorman.springdata.jpa.entity.Competence;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ApplicantSpecs {

    public static Specification<Applicant> hasCompetence(final Competence competence) {
        return new Specification<Applicant>() {
            public Predicate toPredicate(Root<Applicant> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.isMember(competence, root.get(Applicant_.competences));
            }
        };
    }

}
