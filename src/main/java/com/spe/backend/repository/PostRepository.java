package com.spe.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spe.backend.model.Post;
import com.spe.backend.model.Profile;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

	List<Post> findByProfileUserId(long userId);
}
