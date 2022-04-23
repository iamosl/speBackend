package com.spe.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spe.backend.model.Profile;
import com.spe.backend.model.Project;
import com.spe.backend.service.ProjectService;

@RequestMapping("api/project")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProjectController {
	
	private final ProjectService projectService;
	
	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	//API to Add a new Consultation record to the database 
	@PostMapping
	public Project addNewProject(@RequestBody Project project) {
		return projectService.addNewProject(project);
	}
	
	//API to Add a new Consultation record to the database 
	@GetMapping
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}
	
	@GetMapping(path = "/userId/{id}")
	public List<Project> getAllProjectsByUserId(@PathVariable(value = "id", required = true) long id) {
		return projectService.getAllProjectsByUserId(id);
	}
	
	//API to update a Project given a Project Id
	@PostMapping(path = "/update/{id}")
	public Project updateProjectById(@PathVariable(value = "id", required = true) long id,@RequestBody Project project) {
		return projectService.updateProject(id, project);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public void deleteProjectbyId(@PathVariable(value = "id", required = true) long id)
	{
		projectService.deleteProject(id);
	}

}
