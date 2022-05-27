package com.ub.fmi.demo.service;


import com.ub.fmi.demo.domain.User;
import com.ub.fmi.demo.web.rest.dto.UserDTO;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserService {
    List<User> getUsers();

    UserDTO getById(Long id);

    UserDTO createUser(User user);

    void deleteUser(Long id);

    UserDTO updateUser(User user);

    UserDTO getUserByUsername(String username);

    void sendEmailForAccountActivation(String email, String link) throws MessagingException, UnsupportedEncodingException;

    void activateAccount(String token);

    void changeRole(Long id, String role);

    String updateImage(Long id, byte[] content, String extension);

    String getUserRole(String username);

    void generateResetPasswordToken(String email);

    void resetPassword(String token, String password);

    UserDTO userToUserDTO(User user);
}

