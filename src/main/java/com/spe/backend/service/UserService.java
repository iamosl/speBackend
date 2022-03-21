package com.spe.backend.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spe.backend.dto.request.SignInDto;
import com.spe.backend.dto.request.SignUpDto;
import com.spe.backend.dto.response.SignInResponseDto;
import com.spe.backend.dto.response.SignUpResponseDto;
import com.spe.backend.exception.CustomException;
import com.spe.backend.model.User;
import com.spe.backend.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public SignUpResponseDto signUp(SignUpDto signupDto) throws CustomException{
		if(userRepository.existsByEmail(signupDto.getEmail()))
		{
			System.out.println("User Already exists!");
			throw new CustomException("User already exists"); 
		}
		User user = new User(signupDto.getEmail(),signupDto.getPassword() ,signupDto.getName());
		try {
            // save the User
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
        User user = userRepository.findByEmail(signInDto.getEmail());
        if(!Objects.nonNull(user)){
        	System.out.println("User does not exist!");
        	throw  new CustomException("Incorrect Password or Email ID");
        }
        // check if password is right
        if (!user.getPassword().equals((signInDto.getPassword()))){
        // passwords do not match
            throw  new CustomException("Incorrect Password or Email ID");
        }
        return new SignInResponseDto ("success");
    }
	
}
