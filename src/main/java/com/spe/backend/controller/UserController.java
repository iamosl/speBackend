package com.spe.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spe.backend.dto.request.SignInDto;
import com.spe.backend.dto.request.SignUpDto;
import com.spe.backend.dto.response.SignInResponseDto;
import com.spe.backend.dto.response.SignUpResponseDto;
import com.spe.backend.exception.CustomException;
import com.spe.backend.service.UserService;

//@RequestMapping("/login")
@CrossOrigin(origins = {"http://localhost:3000", "http://20.239.187.64:3000"})
@RestController
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;
    
//    API to register a new user to the system
    @PostMapping("/signUp")
    public SignUpResponseDto Signup(@RequestBody SignUpDto signupDto) throws CustomException {
    	logger.info("Sign Up new user");
        return userService.signUp(signupDto);
    }
    
//    API to login 
    @PostMapping("/signIn")
    public SignInResponseDto Signin(@RequestBody SignInDto signInDto) throws CustomException {
    	logger.info("Login");
        return userService.signIn(signInDto);
    }

}