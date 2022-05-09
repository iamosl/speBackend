package com.spe.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spe.backend.model.Post;
import com.spe.backend.model.Profile;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

	List<Post> findByProfileUserId(long userId);
	
	Optional<Post> findById(Long id);
	
	@Transactional
	@Modifying
	@Query("update Post p set p.title = ?1 where p.id = ?2")
	void updatePostTitle(String title, long postId);
}
