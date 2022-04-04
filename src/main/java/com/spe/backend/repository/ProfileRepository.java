package com.spe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spe.backend.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long>{

}
