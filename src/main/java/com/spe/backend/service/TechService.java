package com.spe.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spe.backend.model.Tech;
import com.spe.backend.repository.TechRepository;

@Service
public class TechService {
	
	@Autowired
	private TechRepository techRepository;

	public Tech addNewTech(Tech tech) {
		return techRepository.save(tech);
	}

	public List<Tech> getAllTechs() {
		List<Tech> records = new ArrayList<Tech>();
		techRepository.findAll().forEach(records::add);
		return records;
	}

}
