package com.spe.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spe.backend.model.Profile;
import com.spe.backend.service.ProfileService;

@RequestMapping("api/profile")
@CrossOrigin(origins = {"http://localhost:3000", "http://20.239.187.64:3000"})
@RestController
public class ProfileController {

	private final ProfileService profileService;
	
	@Autowired
	public ProfileController(ProfileService profileService) {
		this.profileService = profileService;
	}
	
	//API to Add a new profile to the database 
	@PostMapping
	public Profile addNewProfile(@RequestBody Profile profile) {
		return profileService.addNewProfile(profile);

	}
		
	//API to Get all Profiles in the database
	@GetMapping
	public List<Profile> getAllProfiles() {
		List<Profile> records = profileService.getAllProfiles();
		return records;
	}
	
	@GetMapping(path = "/userId/{id}")
	public Profile getProfileByUserId(@PathVariable(value = "id", required = true) long id) {
		return profileService.getByUserId(id);
	}
	
	//API to update a Profile given a Profile Id
	@PutMapping(path = "/update/{id}")
	public Profile updateProfile(@PathVariable(value = "id", required = true) long id,@RequestBody Profile profile) {
		return profileService.updateProfile(id, profile);
	}
}
