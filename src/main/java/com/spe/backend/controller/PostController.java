package com.spe.backend.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.spe.backend.model.Post;
import com.spe.backend.model.Profile;
import com.spe.backend.model.Project;
import com.spe.backend.service.PostService;

@RequestMapping("api/post")
@CrossOrigin(origins = {"http://localhost:3000", "http://20.239.187.64:3000"})
@RestController
public class PostController {
	Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	private PostService ServiceHandler;
	
	@GetMapping
	public List<Post> getAllPosts(){
		return this.ServiceHandler.getAllPosts();
	}
	

	@PreAuthorize("hasPermission(#post,'post_user:write')")
	@PostMapping
	public void addPost(@RequestBody Post post) {
		logger.info("add a new post");
		this.ServiceHandler.addPost(post);
	}
	
	@GetMapping(path = "/userId/{id}")
	public List<Post> getAllPostsByUserId(@PathVariable(value = "id", required = true) long id) {
		logger.info("get all posts by user id");
		return ServiceHandler.getAllPostsByUserId(id);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Post> getPostByPostId(@PathVariable(value = "id", required = true) long id) {
		logger.info("get a post");
		return ServiceHandler.getPostById(id);
	}

	@PreAuthorize("hasPermission(#post,'post_user:update')")
	@PutMapping(path = "/update")
	public Post updatePostById(@RequestBody Post post) {
		logger.info("update a post");
		return ServiceHandler.updatePost(post);
	}

	@PreAuthorize("hasPermission(#id,'post_user:delete')")
	@DeleteMapping(path="/delete/{id}")
	public void deletePostbyId(@PathVariable(value = "id", required = true) long id)
	{
		logger.info("delete a post");
		ServiceHandler.deleteProject(id);
	}
	
	@PostMapping(path = "/addInterested/{id}")
	public void addInterestedProfile(@PathVariable(value = "id", required = true) long id,
									 @RequestBody Profile profile) {
		logger.info("add interested profile to a post");
		ServiceHandler.addInterestedProfile(id, profile);
	}
}
