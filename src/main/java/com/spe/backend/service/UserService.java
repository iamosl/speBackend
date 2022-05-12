package com.spe.backend.service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.google.common.collect.Sets;
import com.spe.backend.security.AssignAuthorities;
import com.spe.backend.security.UserPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spe.backend.dto.request.SignInDto;
import com.spe.backend.dto.request.SignUpDto;
import com.spe.backend.dto.response.SignInResponseDto;
import com.spe.backend.dto.response.SignUpResponseDto;
import com.spe.backend.exception.CustomException;
import com.spe.backend.model.Profile;
import com.spe.backend.model.User;
import com.spe.backend.repository.UserRepository;

import static com.spe.backend.security.UserPermission.*;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

    @Autowired
    AssignAuthorities assignAuthorities;

	public SignUpResponseDto signUp(SignUpDto signupDto) throws CustomException{
		if(userRepository.existsByEmail(signupDto.getEmail()) || userRepository.existsByUsername(signupDto.getUsername()))
		{
			System.out.println("User Already exists!");
			throw new CustomException("User already exists"); 
		}
        Set<UserPermission> permissions = Sets.newHashSet(UserPermission.class.getEnumConstants());
		User user = new User(signupDto.getEmail(),
                signupDto.getPassword() ,
                signupDto.getUsername(),null);
        user.setAuthorities(assignAuthorities.getGrantedAuthorities(permissions));
		try {
            // save the User
//			System.out.println(user.getEmail());
            userRepository.save(user);
            // success in creating
            return new SignUpResponseDto("success", "user created successfully");
        } catch (Exception e) {
            // handle sign up error
            throw new CustomException(e.getMessage());
        }
	}

	public SignInResponseDto signIn(SignInDto signInDto) throws CustomException{
		// first find User by email
        User user = userRepository.findByUsername(signInDto.getUsername());
        if(!Objects.nonNull(user)){
        	System.out.println("User does not exist!");
        	throw  new CustomException("Incorrect Password or Username");
        }
        // check if password is right
        if (!user.getPassword().equals((signInDto.getPassword()))){
        // passwords do not match
            throw  new CustomException("Incorrect Password or Username  ");
        }
        user.setPassword(null); 
        return new SignInResponseDto ("success",user);
    }
	
}
