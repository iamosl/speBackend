package com.spe.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spe.backend.model.Profile;
import com.spe.backend.model.Project;
import com.spe.backend.service.ProjectService;

@RequestMapping("api/project")
@CrossOrigin(origins = {"http://localhost:3000", "http://20.239.187.64:3000"})
@RestController
public class ProjectController {
	
	Logger logger = LoggerFactory.getLogger(ProjectController.class);
	private final ProjectService projectService;
	
	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	//API to Add a new Project to the database
	@PreAuthorize("hasPermission(#project,'project_user:write')")
	@PostMapping
	public Project addNewProject(@RequestBody Project project) {
		logger.info("add a new project");
		return projectService.addNewProject(project);
	}
	
	//API to get all projects from the database 
	@GetMapping
	public List<Project> getAllProjects() {
		logger.info("get all projects");
		return projectService.getAllProjects();
	}


	@GetMapping(path = "/userId/{id}")
	public List<Project> getAllProjectsByUserId(@PathVariable(value = "id", required = true) long id) {
		logger.info("get all proejcts of a user");
		return projectService.getAllProjectsByUserId(id);
	}
	
	//API to update a Project given a Project Id
	@PreAuthorize("hasPermission(#project,'project_user:update')")
	@PutMapping(path = "/update")
	public Project updateProjectById(@RequestBody Project project) {
		logger.info("update a project");
		return projectService.updateProject(project);
	}

	@PreAuthorize("hasPermission(#id,'project_user:delete')")
	@DeleteMapping(path="/delete/{id}")
	public void deleteProjectbyId(@PathVariable(value = "id", required = true) long id)
	{
		logger.info("delete a project");
		projectService.deleteProject(id);
	}

}
