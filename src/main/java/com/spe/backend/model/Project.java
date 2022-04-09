package com.spe.backend.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {
	
	public Project() {}

	public Project(String name, String description, String projectLink) {
		super();
		this.name = name;
		this.description = description;
		this.projectLink = projectLink;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	// many to one relationship to the profile class
	@ManyToOne(optional = false)
    @JoinColumn(name="profileId")
    private Profile profile;

	@Column(nullable = false, length = 40)
    private String name;
	
	@Column(nullable = false, length=512)
    private String description;
	
	@Column(nullable = false, length=512)
    private String projectLink;
	
	//Many to many relationship with Tech (skills)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	name = "project_skills", 
				joinColumns = @JoinColumn(name = "project_id"), 
				inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private Set<Tech> skills = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProjectLink() {
		return projectLink;
	}

	public void setProjectLink(String projectLink) {
		this.projectLink = projectLink;
	}

	public Set<Tech> getSkills() {
		return skills;
	}

	public void setSkills(Set<Tech> skills) {
		this.skills = skills;
	}
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
}
