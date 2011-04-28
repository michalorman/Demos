package pl.michalorman.springdata.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.michalorman.springdata.jpa.entity.Applicant;
import pl.michalorman.springdata.jpa.entity.Competence;
import pl.michalorman.springdata.jpa.repository.ApplicantsRepository;
import pl.michalorman.springdata.jpa.repository.CompetencesRepository;

import java.util.List;

@Controller
@RequestMapping("/applicants")
public class ApplicantsController {

    @Autowired
    private ApplicantsRepository applicantsRepository;

    @Autowired
    private CompetencesRepository competencesRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    private List<Applicant> list() {
        return applicantsRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, params = "size")
    @ResponseBody
    private List<Applicant> list(int size, int page) {
        return applicantsRepository.findAll(new PageRequest(page, size)).getContent();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    private Applicant create(Applicant applicant) {
        return applicantsRepository.save(applicant);
    }

    @RequestMapping(value = "/{applicantId}/competences/add", method = RequestMethod.POST)
    @ResponseBody
    private Applicant addCompetence(@PathVariable("applicantId") Long applicantId, Long competenceId) {
        Applicant applicant = applicantsRepository.findOne(applicantId);
        applicant.addCompetence(competencesRepository.findOne(competenceId));
        return applicantsRepository.save(applicant);
    }
}
