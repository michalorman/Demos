package pl.michalorman.springdata.jpa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.michalorman.springdata.jpa.entity.Applicant;
import pl.michalorman.springdata.jpa.entity.Competence;
import pl.michalorman.springdata.jpa.entity.QApplicant;
import pl.michalorman.springdata.jpa.repository.ApplicantsRepository;
import pl.michalorman.springdata.jpa.repository.CompetencesRepository;
import pl.michalorman.springdata.jpa.spec.ApplicantSpecs;

import java.util.List;

import static pl.michalorman.springdata.jpa.spec.ApplicantSpecs.hasCompetence;

@Controller
@RequestMapping("/applicants")
public class ApplicantsController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicantsController.class);

    @Autowired
    private ApplicantsRepository applicantsRepository;

    @Autowired
    private CompetencesRepository competencesRepository;

    @RequestMapping(method = RequestMethod.GET)
    private @ResponseBody List<Applicant> list() {
        return applicantsRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, params = "size")
    private @ResponseBody List<Applicant> list(int size, int page) {
        return applicantsRepository.findAll(new PageRequest(page, size)).getContent();
    }

    /*
     * Search applicants using one from 3 different methods:
     *  1. Using JPA criteria API
     *  2. Using QueryDSL framework
     *  3. Using native query
     */
    @RequestMapping(method = RequestMethod.GET, params = "competenceId")
    private @ResponseBody List<Applicant> list(Long competenceId, String method) {
        Competence competence = competencesRepository.findOne(competenceId);

        if ("JPA_CRITERIA".equals(method)) {
            logger.info("Querying using JPA criteria API");
            return applicantsRepository.findAll(hasCompetence(competence));
        }

        if ("QUERYDSL".equals(method)) {
            logger.info("Querying using QueryDSL framework");
            QApplicant applicant = QApplicant.applicant;
            return applicantsRepository.findAll(applicant.competences.contains(competence));
        }

        // if method not specified fallback to native query
        logger.info("Querying using named query");
        return applicantsRepository.findWithCompetence(competence);
    }

    @RequestMapping(method = RequestMethod.POST)
    private @ResponseBody Applicant create(Applicant applicant) {
        return applicantsRepository.save(applicant);
    }

    @RequestMapping(value = "/{applicantId}/competences/add", method = RequestMethod.POST)
    private @ResponseBody Applicant addCompetence(@PathVariable("applicantId") Long applicantId, Long competenceId) {
        Applicant applicant = applicantsRepository.findOne(applicantId);
        applicant.addCompetence(competencesRepository.findOne(competenceId));
        return applicantsRepository.save(applicant);
    }
}
