package com.spe.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spe.backend.model.Tech;
import com.spe.backend.service.TechService;

@RequestMapping("api/skill")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TechController {
	
	private final TechService techService;
	
	@Autowired
	public TechController(TechService techService) {
		this.techService = techService;
	}

	//API to Add a new Skill to the database 
	@PostMapping
	public Tech addNewTech(@RequestBody Tech tech) {
		return techService.addNewTech(tech);
		}
			
	//API to Get all Consultation records in the database
	@GetMapping
	public List<Tech> getAllTechs() {
		List<Tech> records = techService.getAllTechs();
		return records;
	}	
}
