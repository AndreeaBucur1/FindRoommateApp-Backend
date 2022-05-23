package com.ub.fmi.demo.web.rest;

import com.ub.fmi.demo.problem.AuthenticationException;
import com.ub.fmi.demo.repository.UserRepository;
import com.ub.fmi.demo.security.JwtTokenProvider;
import com.ub.fmi.demo.service.AuthenticationService;
import com.ub.fmi.demo.service.UserService;
import com.ub.fmi.demo.web.rest.dto.JwtTokenDto;
import com.ub.fmi.demo.web.rest.dto.LoginRequestDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthenticationController {


    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
    public JwtTokenDto login(@Valid @RequestBody LoginRequestDto loginRequestDto){
        System.out.println(loginRequestDto);
        boolean isAuthenticated = authenticationService.authenticate(loginRequestDto.getUsername(),
                loginRequestDto.getPassword());

        JwtTokenDto result = new JwtTokenDto();
        String token = JwtTokenProvider.createToken(userService.getUserByUsername(loginRequestDto.getUsername()));
        String role = userRepository.findByUsername(loginRequestDto.getUsername()).get().getRole();
        result.setToken(token);
        result.setRole(role);
        if(isAuthenticated){
            return result;
        }
        else{
            throw new AuthenticationException();
        }
    }

}
