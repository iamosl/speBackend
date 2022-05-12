package com.spe.backend;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.spe.backend.controller.PostController;
import com.spe.backend.controller.ProfileController;
import com.spe.backend.controller.ProjectController;
import com.spe.backend.controller.UserController;
import com.spe.backend.model.Authority;
import com.spe.backend.model.Post;
import com.spe.backend.model.Profile;
import com.spe.backend.model.Project;
import com.spe.backend.model.Tech;
import com.spe.backend.model.User;
import com.spe.backend.repository.PostRepository;
import com.spe.backend.repository.ProfileRepository;
import com.spe.backend.repository.ProjectRepository;
import com.spe.backend.repository.TechRepository;
import com.spe.backend.repository.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class SpeBackendApplicationTests {
	
	@Autowired
	private UserController userController;
	@Autowired
	private ProfileController profileController;
	@Autowired
	private ProjectController projectController;
	@Autowired
	private PostController postController;
	
	@Test
	public void contextLoads() {
	    assertThat(userController).isNotNull();
	    assertThat(profileController).isNotNull();
	    assertThat(projectController).isNotNull();
	    assertThat(postController).isNotNull();
	  }
	
	

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private TechRepository techRepository;
	
	@Test
	public void testLoginValidationSuccess() throws URISyntaxException
	{
		User user = userRepository.findByEmail("test@test.org");
		System.out.println(user);
		String pass = user.getPassword();
		Assert.assertEquals(true,pass.equals("password"));

	}
	
	@Test
	public void testLoginValidationFailure() throws URISyntaxException
	{
		User user = userRepository.findByEmail("test@test.org");
		String pass = user.getPassword();
		Assert.assertEquals(false,pass.equals("wrongpassword"));
	}
	
	@Test
	public void testGetSkills()
	{
		List<Tech> lst = techRepository.findAll();
		Assert.assertEquals(15, lst.size());
	}	
	
	@BeforeAll
	public void setUp() {
		System.out.println("Test.setUp");
		
		//Adding the dummy user
		Set<Authority> auth = new HashSet<>();
		User testUser = new User("test@test.org","password","TestUser",auth);
		User savedUser = userRepository.save(testUser);
		//Adding the dummy profile
		Profile testProfile = new Profile("Student","Front End Developer","TestUser","Test");
		testProfile.setUser(savedUser);
		Profile savedProfile = profileRepository.save(testProfile);
		//Adding the dummy project
		Project testProject = new Project("Test project","dummy","dummy");
		testProject.setProfile(savedProfile);
		System.out.println(testProject);
		//Adding a dummy post
		Post testPost = new Post("dummy post","dummy");
		testPost.setProfile(savedProfile);
		
	}
	
	@AfterAll 
	public void clearUp() {
		System.out.println("Test.clear");
		User user = userRepository.findByEmail("test@test.org");
		Profile profile = profileRepository.findByUserId(user.getId());
		List<Project> projects = projectRepository.findByProfileUserId(user.getId());
		for(Project p: projects)
		{
			projectRepository.deleteById(p.getId());
		}
		List<Post> posts = postRepository.findByProfileUserId(user.getId());
		for(Post po: posts)
		{
			postRepository.deleteById(po.getId());
		}
		profileRepository.deleteById(profile.getId());
		userRepository.deleteById(user.getId());
	}

}
