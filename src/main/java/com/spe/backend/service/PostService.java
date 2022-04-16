package com.spe.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spe.backend.model.Post;
import com.spe.backend.model.Project;
import com.spe.backend.model.User;
import com.spe.backend.repository.PostRepository;
import com.spe.backend.repository.UserRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository PostHandler;
		
	public List<Post> getAllPosts() {
		return this.PostHandler.findAll();
	}
	
	public void addPost(Post post) {
		System.out.println(post.getDescription());
		this.PostHandler.save(post);
	}

	public List<Post> getAllPostsByUserId(long userId) {
		return this.PostHandler.findByProfileUserId(userId);
	}
	
}
