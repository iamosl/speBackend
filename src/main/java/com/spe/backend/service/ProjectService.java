package com.spe.backend.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spe.backend.model.Project;
import com.spe.backend.model.Tech;
import com.spe.backend.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project addNewProject(Project p) {
//		Project pro = new Project(p.getName(),p.getDescription(),p.getProjectLink());
//		Set<Tech> skills = new HashSet();
//		for(Tech s: p.getSkills())
//		{
//			skills.add(s);
//		}
//		pro.setProfile(p.getProfile());
//		pro.setSkills(skills);
		return projectRepository.save(p);
		
	}

	public List<Project> getAllProjects() {
		List<Project> records = new ArrayList<Project>();
		projectRepository.findAll().forEach(records::add);
		return records;
	}
	
	public List<Project> getAllProjectsByUserId(long userId){
		List<Project> records = new ArrayList<Project>();
		records = projectRepository.findByProfileUserId(userId);
		return records;
	}
	
	public Project updateProject(Project newProject)
	{
		Project projectDb = projectRepository.findById(newProject.getId()).orElse(null);
		projectDb = newProject;
		return projectRepository.save(projectDb);
	}
	
	public void deleteProject(long projectId)
	{
		projectRepository.deleteById(projectId);
	}
}
