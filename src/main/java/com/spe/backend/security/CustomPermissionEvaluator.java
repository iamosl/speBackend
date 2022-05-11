package com.spe.backend.security;

import com.spe.backend.model.Post;
import com.spe.backend.model.Profile;
import com.spe.backend.model.Project;
import com.spe.backend.model.User;
import com.spe.backend.repository.PostRepository;
import com.spe.backend.repository.ProfileRepository;
import com.spe.backend.repository.ProjectRepository;
import com.spe.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

@Configuration
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
        if(auth==null || targetDomainObject == null || !(permission instanceof String))
            return false;
        System.out.println(auth.getName());
        System.out.println(targetDomainObject.toString());
        System.out.println(permission.toString());
        System.out.println(auth.getAuthorities().contains(permission.toString()));
        if(permission.equals("profile_user:add") || permission.equals("profile_user:write")){
            Profile profile = (Profile) targetDomainObject;
            User user = userRepository.findById(profile.getUser().getId()).orElse(null);
            if(user==null)  return false;
            return user.getUsername().equals(auth.getName());
        }
        else if(permission.equals("profile_user:read")){
            long id = (long) targetDomainObject;
            return userRepository.findById(id).getUsername().equals(auth.getName());
        }
        else if (permission.equals("project_user:write")) {
            Project project = (Project) targetDomainObject;
            User user = userRepository.findById(project.getProfile().getUser().getId()).orElse(null);
            if(user==null) return false;
            return user.getUsername().equals(auth.getName());
        }
        else if(permission.equals("project_user:update")){
            Project project = (Project) targetDomainObject;
            User user = userRepository.findById(project.getProfile().getUser().getId()).orElse(null);
            if(user == null) return false;
            return user.getUsername().equals(auth.getName());
        }
        else if(permission.equals("project_user:delete")){
            long id = (long) targetDomainObject;
            Project project = projectRepository.findById(id).orElse(null);
            if(project==null) return false;
            User user = userRepository.findById(project.getProfile().getUser().getId()).orElse(null);
            if(user == null) return false;
            return user.getUsername().equals(auth.getName());
        }
        else if (permission.equals("post_user:write")) {
            Post post = (Post) targetDomainObject;
            User user = userRepository.findById(post.getProfile().getUser().getId()).orElse(null);
            if(user==null) return false;
            return user.getUsername().equals(auth.getName());
        }
        else if(permission.equals("post_user:update")){
            Post post = (Post) targetDomainObject;
            User user = userRepository.findById(post.getProfile().getUser().getId()).orElse(null);
            if(user == null) return false;
            return user.getUsername().equals(auth.getName());
        }
        else if(permission.equals("post_user:delete")){
            long id = (long) targetDomainObject;
            Post post = postRepository.findById(id).orElse(null);
            if(post==null) return false;
            User user = userRepository.findById(post.getProfile().getUser().getId()).orElse(null);
            if(user == null) return false;
            return user.getUsername().equals(auth.getName());
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
