package com.spe.backend.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.spe.backend.model.*;
import com.spe.backend.repository.PostRepository;
import com.spe.backend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spe.backend.repository.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private PostRepository postRepository;
	
	public Profile addNewProfile(Profile profile) {
//		Profile prof = profileRepository.findById(profile.getId()).orElse(null);
//		if(prof==null)
//			return profileRepository.save(profile);
//		prof=profile;
		return profileRepository.save(profile);
	}

	public List<Profile> getAllProfiles() {
		List<Profile> records = new ArrayList<Profile>();
		profileRepository.findAll().forEach(records::add);
		return records;
	}
	
	public Profile getByUserId(long userId){
		return profileRepository.findByUserId(userId);
	}
	
	public Profile updateProfile(Profile newProfile)
	{
		Profile oldProfile = profileRepository.findById(newProfile.getId()).orElse(null);
		if(oldProfile==null)
			return profileRepository.save(newProfile);
		oldProfile = newProfile;
		return profileRepository.save(oldProfile);
	}

	public PublicProfile getByUsername(String username) {
		Profile profile = profileRepository.findByUserUsername(username);
		List<Project> projects = projectRepository.findByProfileUserId(profile.getUser().getId());
		projects.stream().forEach(
				project -> project.setProfile(null));
		List<Post> posts = postRepository.findByProfileUserId(profile.getUser().getId());
		posts.stream().forEach(
				post -> post.setProfile(null));

		PublicProfile prof = new PublicProfile(
				profile.getUser().getUsername(),
				profile.getName(),
				projects,
				posts,
				profile.getSkills(),
				profile.getExpertise()
		);
		return prof;
	}
}
