package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {


    @ManyToOne
    public Employer employer;

    @ManyToMany
    private List<Skill> skills = new ArrayList<>();

//    private String skills;

    public Job() {
    }

    public Job(Employer anEmployer, List<Skill> someSkills) {
//public Job(Employer anEmployer, List<Skill> someSkills) {
        super();
        this.employer = anEmployer;
        this.skills = someSkills;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
//        this.skills.addAll(skills);
    }

    public void addAllSkills(List<Skill> skills) {
        this.skills.addAll(skills);
    }

//    public void addSkills(List<Skill> skills) {
//        this.skills.add(skills);
//    }


//    public void addAllSkill(Skill skill) {
//        this.skills.addAll(skills);
//    }



//    public String getSkills() {
//        return skills;
//    }
//
//    public void setSkills(String skills) {
//        this.skills = skills;
//    }

}
