package pl.michalorman.springdata.jpa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.michalorman.springdata.jpa.entity.Competence;
import pl.michalorman.springdata.jpa.repository.CompetencesRepository;

import java.util.List;

@Controller
@RequestMapping("/competences")
public class CompetencesController {
    @Autowired
    private CompetencesRepository competencesRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    private List<Competence> list() {
        return competencesRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, params = "size")
    @ResponseBody
    private List<Competence> list(Integer size, Integer page) {
        return competencesRepository.findAll(new PageRequest(page, size)).getContent();
    }

    @RequestMapping(method = RequestMethod.GET, params = "name")
    @ResponseBody
    private List<Competence> list(String name) {
        return competencesRepository.findByNameLike(name.replace('*', '%'));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    private Competence create(Competence competence) {
        return competencesRepository.save(competence);
    }

}
