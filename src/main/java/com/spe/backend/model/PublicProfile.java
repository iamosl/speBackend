package com.spe.backend.model;

import java.util.List;
import java.util.Set;

public class PublicProfile {
    private String username;
    private String name;
    private List<Project> projectList;
    private List<Post> postList;
    private Set<Tech> skills;
    private String expertise;

    public PublicProfile(String username,
                         String name,
                         List<Project> projectList,
                         List<Post> postList,
                         Set<Tech> skills,
                         String expertise) {
        this.username = username;
        this.name = name;
        this.projectList = projectList;
        this.postList = postList;
        this.skills = skills;
        this.expertise = expertise;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public Set<Tech> getSkills() {
        return skills;
    }

    public void setSkills(Set<Tech> skills) {
        this.skills = skills;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
}
