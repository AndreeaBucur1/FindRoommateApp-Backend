package com.ub.fmi.demo.web.rest;

import com.ub.fmi.demo.repository.UserRepository;
import com.ub.fmi.demo.security.JwtTokenProvider;
import com.ub.fmi.demo.service.AuthenticationService;
import com.ub.fmi.demo.service.UserService;
import com.ub.fmi.demo.web.rest.dto.JwtTokenDto;
import com.ub.fmi.demo.web.rest.dto.LoginRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
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
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<JwtTokenDto> login(@Valid @RequestBody LoginRequestDto loginRequestDto) throws AuthenticationException {
        authenticationService.authenticate(loginRequestDto.getUsername(),
                loginRequestDto.getPassword());

        JwtTokenDto result = new JwtTokenDto();
        String token = JwtTokenProvider.createToken(userService.getUserByUsername(loginRequestDto.getUsername()));
        result.setToken(token);


        return ResponseEntity.ok(result);
    }

}
