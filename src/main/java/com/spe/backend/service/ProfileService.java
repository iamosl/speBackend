package com.spe.backend.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spe.backend.model.Profile;
import com.spe.backend.model.Project;
import com.spe.backend.model.Tech;
import com.spe.backend.repository.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	public Profile addNewProfile(Profile profile) {
		Profile newProfile = new Profile(profile.getProfession(),profile.getExpertise(),profile.getExperience(),profile.getBio());
		newProfile.setUser(profile.getUser());
		ArrayList<Project> projects = new ArrayList<>();
//		for(Project p: profile.getProjects())
//		{	
//			Project pro = new Project(p.getName(),p.getDescription(),p.getProjectLink());
//			Set<Tech> skills = new HashSet();
//			for(Tech s: p.getSkills())
//			{
//				skills.add(s);
//			}
//			pro.setSkills(skills);
//			projects.add(pro);
//		}
//		newProfile.setProjects(projects);
		Set<Tech> skills = new HashSet();
		for(Tech s: profile.getSkills())
		{
			skills.add(s);
		}
		newProfile.setSkills(skills);
		return profileRepository.save(newProfile);
		
	}

	public List<Profile> getAllProfiles() {
		List<Profile> records = new ArrayList<Profile>();
		profileRepository.findAll().forEach(records::add);
		return records;
	}
}
