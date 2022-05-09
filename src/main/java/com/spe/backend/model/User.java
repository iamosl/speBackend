package com.spe.backend.model;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "users")
public class User {
	
	public User() {}

	public User(String email, String password, String name) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(nullable = false, unique = true, length = 45)
    private String email;
     
    @Column(nullable = false, length = 64)
    private String password;
     
    @Column(nullable = false, length = 20)
    private String name;
    
//    @OneToOne(mappedBy = "user")
//    private Profile profile;
//    
//	public Profile getProfile() {
//		return profile;
//	}
//
//	public void setProfile(Profile profile) {
//		this.profile = profile;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	

}
