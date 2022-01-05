package com.ub.fmi.demo.service.implementation;

import com.ub.fmi.demo.SecurityConfiguration;
import com.ub.fmi.demo.domain.User;
import com.ub.fmi.demo.problem.AuthenticationException;
import com.ub.fmi.demo.repository.UserRepository;
import com.ub.fmi.demo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {


    @Autowired
    private SecurityConfiguration securityConfiguration;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public boolean authenticate(String username, String password)  {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new com.ub.fmi.demo.problem.AuthenticationException());
        if (user.getPassword().compareTo(password) != 0) {
            throw new AuthenticationException();
        }
//        if (!user.isEmailConfirmation()) {
//            throw new UserNotActivatedException();
//        }

        return true;
    }


}
