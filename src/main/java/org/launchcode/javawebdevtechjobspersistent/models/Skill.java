package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    @Size(max = 250)
    private String description;

//    @JoinColumn
    @ManyToMany(mappedBy = "skills")
    private List<Job> jobs = new ArrayList<>();
//    private final List<Job> jobs = new ArrayList<>();


    public Skill() {
    }

    public String getDescription() {
        return description;
    }

//    public List<Skill> getSkills() {
//        return skills;
//    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

