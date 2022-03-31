package com.spe.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	//One to One link with user table
	
	//Many to Many relationship with Tech (skills)
	
	//working or student options given in the front-end
	@Column(nullable = false, length = 20)
    private String profession;
	
	//front-end, back-end and full-stack options given in the front-end
	@Column(nullable = false, length = 20)
	private String expertise;
}
