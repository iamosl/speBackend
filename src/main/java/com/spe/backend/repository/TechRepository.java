package com.spe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spe.backend.model.Tech;

@Repository
public interface TechRepository extends JpaRepository<Tech,Long>{

}
