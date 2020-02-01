package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    @Size(max = 250)
    private String description;

    @ManyToMany(mappedBy = "skills")
    private final List<Job> jobs = new ArrayList<>();


    public Skill() {
    }

    public String getDescription() {
        return description;
    }

//    public List<Skill> getSkills() {
//        return skills;
//    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

