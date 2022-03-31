package com.spe.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	// TO add fk many to one link to user_profile
	
	@Column(nullable = false, length = 40)
    private String name;
	
	@Column(nullable = false, length=512)
    private String description;
	
	@Column(nullable = false, length=512)
    private String projectLink;
	
	//Not yet sure about the tech stack field 	
}
