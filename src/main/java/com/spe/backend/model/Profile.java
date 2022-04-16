package com.spe.backend.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "profile")
public class Profile {
	
	public Profile() {}

	public Profile(String profession, String expertise, String experience, String bio) {
		super();
		this.profession = profession;
		this.expertise = expertise;
		this.experience = experience;
		this.bio = bio;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	//One to One link with user table
	@OneToOne
    @JoinColumn(name="userId")
    private User user;
	
	//Many to many relationship with Tech (skills)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	name = "profile_skills", 
				joinColumns = @JoinColumn(name = "profile_id"), 
				inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private Set<Tech> skills = new HashSet<>();
	
	//working or student options given in the front-end
	@Column(nullable = false,length = 20)
    private String profession;
	
	//front-end, back-end and full-stack options given in the front-end
	@Column(nullable = false,length = 20)
	private String expertise;
	
	//experience on a scale of 1-5 for the given expertise
	@Column(nullable = false,length = 20)
	private String experience;
	
	@Column(nullable = false,length=512)
    private String bio;

//	Getters and setters
	public String getBio() {
			return bio;
		}
	
	public void setBio(String bio) {
		this.bio = bio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public List<Project> getProjects() {
//		return projects;
//	}
//
//	public void setProjects(List<Project> projects) {
//		this.projects = projects;
//	}

	public Set<Tech> getSkills() {
		return skills;
	}

	public void setSkills(Set<Tech> skills) {
		this.skills = skills;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
}
