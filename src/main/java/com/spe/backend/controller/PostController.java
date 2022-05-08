package com.spe.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spe.backend.model.Post;
import com.spe.backend.model.Profile;
import com.spe.backend.model.Project;
import com.spe.backend.service.PostService;

@RequestMapping("api/post")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PostController {
	
	@Autowired
	private PostService ServiceHandler;
	
	@GetMapping
	public List<Post> getAllPosts(){
		return this.ServiceHandler.getAllPosts();
	}
	
	@PostMapping
	public void addPost(@RequestBody Post post) {
		System.out.println(post.getDescription());
		this.ServiceHandler.addPost(post);
	}
	
	@GetMapping(path = "/userId/{id}")
	public List<Post> getAllPostsByUserId(@PathVariable(value = "id", required = true) long id) {
		return ServiceHandler.getAllPostsByUserId(id);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Post> getPostByPostId(@PathVariable(value = "id", required = true) long id) {
		return ServiceHandler.getPostById(id);
	}
	
	@PostMapping(path = "/addInterested/{id}")
	public void addInterestedProfile(@PathVariable(value = "id", required = true) long id,@RequestBody Profile profile) {
		ServiceHandler.addInterestedProfile(id, profile);
	}
	
	//API to delete post
    @DeleteMapping("/delete/{id}")
    public void deletePostById(@PathVariable(value = "id", required = true) long id){
    	ServiceHandler.deletePostById(id);
    }
}
