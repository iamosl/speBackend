package com.spe.backend.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spe.backend.model.Profile;
import com.spe.backend.model.Tech;
import com.spe.backend.repository.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	public Profile addNewProfile(Profile profile) {
		Profile newProfile = new Profile(profile.getProfession(),profile.getExpertise(),profile.getExperience(),profile.getBio());
		newProfile.setUser(profile.getUser());
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
	
	public Profile getByUserId(long userId){
		Profile p = profileRepository.findByUserId(userId);
		p.getUser().setPassword(null);
		return p;
	}
	
	public Profile updateProfile(long profileId,Profile newProfile)
	{
		Profile oldProfile = profileRepository.findById(profileId).orElse(null);
		oldProfile = newProfile;
		return profileRepository.save(oldProfile);
	}
}
