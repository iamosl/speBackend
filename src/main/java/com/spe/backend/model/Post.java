package com.spe.backend.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Post")
public class Post {
	
	public Post() {
		super();
	}

	public Post(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public Set<Profile> getInterestedProfiles() {
		return interestedProfiles;
	}

	public void setInterestedProfiles(Set<Profile> interestedProfiles) {
		this.interestedProfiles = interestedProfiles;
	}
	
	public void addInterestedProfile(Profile profile) {
		this.interestedProfiles.add(profile);
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(optional = false)
	private Profile profile;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Tech> skills = new HashSet<>();
	
	@Column(name="Title",length = 40)
	private String title;
	
	@Column(name="Description",length=512)
	private String description;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Profile> interestedProfiles = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Set<Tech> getSkills() {
		return skills;
	}

	public void setSkills(Set<Tech> skills) {
		this.skills = skills;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", profile=" + profile + ", skills=" + skills + ", title=" + title + ", description="
				+ description + ", interestedProfiles=" + interestedProfiles + "]";
	}
	
	
	
	
	
	
}
