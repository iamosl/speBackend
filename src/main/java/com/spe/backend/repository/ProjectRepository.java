package com.spe.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spe.backend.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{
	
	List<Project> findByProfileUserId(long userId);
}
