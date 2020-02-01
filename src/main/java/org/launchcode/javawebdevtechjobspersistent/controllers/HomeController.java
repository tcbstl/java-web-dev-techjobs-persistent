package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "My Jobs");

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute(new Job());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                    Errors errors, Model model, @RequestParam List<Integer> skills, @RequestParam Integer employerId) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }

        Optional<Employer> result = employerRepository.findById(employerId);
        Employer employer = result.get();

        employerRepository.save(employer);
        newJob.employer = employer;
        jobRepository.save(newJob);

        return "redirect:";
    }


//    @GetMapping("view/{employerId}")
//    public String displayViewEmployer(Model model, @PathVariable Integer employerId) {
//
//        Optional optEmployer = employerRepository.findById(employerId);
//
//        if (optEmployer.isPresent()) {
//            Employer employer = (Employer) optEmployer.get();
//            model.addAttribute(employer);
//
//            return "employers/view";
//
//        } else {
//
//            return "redirect:../";
//        }
//    }


    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {
//        @GetMapping("view/{employerId}")
//        public String displayViewEmployer(Model model, @PathVariable Integer employerId) {
//            Optional optEmployer = employerRepository.findById(employerId);
        Optional optJob = jobRepository.findById(jobId);
//            if (optEmployer.isPresent()) {
//                Employer employer = (Employer) optEmployer.get();
//                model.addAttribute(employer);
        if (optJob.isPresent()) {
            Job job = (Job) optJob.get();
            model.addAttribute(job);
//                return "employers/view";
            return "view";
            } else {
                return "redirect:../";
            }
        }
}
