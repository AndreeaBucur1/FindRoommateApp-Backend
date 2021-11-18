package com.ub.fmi.demo.service;


import com.ub.fmi.demo.domain.User;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getById(Long id);

    User createUser(User user);

    void deleteUser(Long id);

    User updateUser(User user);

    User getUserByUsername(String username);

    void sendEmailForAccountActivation(String email, String link) throws MessagingException, UnsupportedEncodingException;

    void activateAccount(String token);

    void changeRole(Long id, String role);


}
