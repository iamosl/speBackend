package com.spe.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spe.backend.dto.request.SignInDto;
import com.spe.backend.dto.request.SignUpDto;
import com.spe.backend.dto.response.SignInResponseDto;
import com.spe.backend.dto.response.SignUpResponseDto;
import com.spe.backend.exception.CustomException;
import com.spe.backend.service.UserService;

@RequestMapping("api/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;
    
    @PostMapping("/signUp")
    public SignUpResponseDto Signup(@RequestBody SignUpDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }
    
    @PostMapping("/signIn")
    public SignInResponseDto Signup(@RequestBody SignInDto signInDto) throws CustomException {
        return userService.signIn(signInDto);
    }

}