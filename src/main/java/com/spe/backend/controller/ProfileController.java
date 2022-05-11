package com.spe.backend.controller;

import java.util.List;

import com.spe.backend.model.PublicProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

	Logger logger = LoggerFactory.getLogger(ProfileController.class);
	private final ProfileService profileService;
	
	@Autowired
	public ProfileController(ProfileService profileService) {
		this.profileService = profileService;
	}
	
	//API to Add a new profile to the database
	@PreAuthorize("hasPermission(#profile,'profile_user:add')")
	@PostMapping
	public Profile addNewProfile(@RequestBody Profile profile) {
		logger.info("add a new profile");
		return profileService.addNewProfile(profile);
	}
		
	//API to Get all Profiles in the database
	@GetMapping
	public List<Profile> getAllProfiles() {
		logger.info("get all profiles");
		List<Profile> records = profileService.getAllProfiles();
		return records;
	}

	@PreAuthorize("hasPermission(#id,'profile_user:read')")
	@GetMapping(path = "/userId/{id}")
	public Profile getProfileByUserId(@PathVariable(value = "id", required = true) long id) {
		logger.info("get profile by userid");
		return profileService.getByUserId(id);
	}
	
	//API to update a Profile given a Profile Id
	@PreAuthorize("hasPermission(#profile,'profile_user:write')")
	@PutMapping(path = "/update/")
	public Profile updateProfile(@PathVariable(value = "id", required = true) long id,@RequestBody Profile profile) {
		logger.info("update a profile");
		return profileService.updateProfile(id, profile);
	}

	@GetMapping(path = "/public/{username}")
	public PublicProfile getPublicProfileByUsername(@PathVariable(value = "username", required = true) String username) {
		logger.info("get public profile by username");
		return profileService.getByUsername(username);
	}
}
