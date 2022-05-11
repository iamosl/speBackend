package com.spe.backend.model;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {
	
	public User() {}

	public User(String email, String password, String name,Set<Authority> authorities) {
		super();
		this.email = email;
		this.password = password;
		this.username = name;
		this.authorities = authorities;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + username + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(nullable = false, unique = true, length = 45)
    private String email;
     
    @Column(nullable = false, length = 64)
    private String password;
     
    @Column(nullable = false, length = 20,unique = true)
    private String username;

	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Authority> authorities;

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	

}
