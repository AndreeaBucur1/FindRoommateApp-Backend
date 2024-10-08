package com.ub.fmi.demo.service.implementation;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.ub.fmi.demo.domain.PropertyPost;
import com.ub.fmi.demo.domain.User;
import com.ub.fmi.demo.repository.PropertyPostRepository;
import com.ub.fmi.demo.repository.RoommatePostRepository;
import com.ub.fmi.demo.repository.UserRepository;
import com.ub.fmi.demo.service.UserService;
import com.ub.fmi.demo.web.rest.dto.UserDTO;
import net.bytebuddy.utility.RandomString;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    PropertyPostRepository propertyPostRepository;

    @Autowired
    RoommatePostRepository roommatePostRepository;

    @Override
    @Transactional
    public List<User> getUsers() {
        return userRepository.findAllByAccountActivatedTrue();
    }

    @Override
    @Transactional
    public UserDTO getById(Long id) {
        return userToUserDTO(userRepository.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public UserDTO createUser(User user) {

        user.setAccountActivated(false);
        user.setRole("USER");
        String activationToken = RandomString.make(75);
        user.setActivationToken(activationToken);

        String link = "http://localhost:4200/activate-account/" + activationToken;
        try {
            sendEmailForAccountActivation(user.getEmail(),link);
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return userToUserDTO(userRepository.save(user));

    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.getById(id);
        if (user.getRoommatePost() != null) {
            roommatePostRepository.delete(user.getRoommatePost());
        }
        List<PropertyPost> propertyPosts = propertyPostRepository.findAllByUser_Username(user.getUsername());
        propertyPostRepository.deleteAll(propertyPosts);
        userRepository.delete(user);
    }

    @Override
    @Transactional
    public UserDTO updateUser(User user) {
        return userToUserDTO(userRepository.save(user));
    }

    @Override
    @Transactional
    public UserDTO getUserByUsername(String username) {
        return userToUserDTO(userRepository.findByUsername(username).orElse(null));
    }

    @Override
    @Transactional
    public void sendEmailForAccountActivation(String email, String link) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("findroommateapp@gmail.com","Find Roommate");
        helper.setTo(email);

        String subject = "Here's the link for your account activation.";

        String content = "<p>Hello,</p>"
                        +"<p>You just created a new account.<p>"
                        +"<p>You must activate it by visiting this URL:<p>"
                        + "<p><a href=\"" + link + "\">Activate account</a></p>"
                        + "<br>"
                        + "<p>If you do not activate your account within 24 hours, you will have to register again<p>";

        helper.setSubject(subject);
        helper.setText(content,true);
        javaMailSender.send(message);
    }

    @Override
    @Transactional
    public void activateAccount(String token) {
        User user = userRepository.findByActivationToken(token).orElse(null);
        if (user != null) {
            user.setAccountActivated(true);
            user.setActivationToken(null);
            userRepository.save(user);
        }
    }

    @Override
    @Transactional
    public void changeRole(Long id, String role) {
        User user = userRepository.getById(id);
        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public String getUserRole(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if(user != null){
            return user.getRole();
        }
        return null;
    }

    @Override
    @Transactional
    public void generateResetPasswordToken(String email) {
     String resetPasswordToken = RandomString.make(75);
     User user = userRepository.findByEmail(email).orElse(null);
     if (user != null) {
         user.setResetPasswordToken(resetPasswordToken);
         userRepository.save(user);
         try{
             sendResetPasswordEmail(user.getEmail(), resetPasswordToken);
         } catch (MessagingException e) {
             throw new RuntimeException(e);
         } catch (UnsupportedEncodingException e) {
             throw new RuntimeException(e);
         }

     }
    }

    @Override
    @Transactional
    public void resetPassword(String token, String password) {
        User user = userRepository.findByResetPasswordToken(token).orElse(null);
        if (user != null) {
            user.setPassword(password);
            user.setResetPasswordToken(null);
            userRepository.save(user);
        }
    }

    @Override
    public UserDTO userToUserDTO(User user) {
        return new UserDTO(user.getUserId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getProfilePhoto(), user.getRole(), user.getUsername(), user.getPhoneNumber(), user.getGender(), user.getRoommatePost());
    }

    public void sendResetPasswordEmail(String email, String resetPasswordToken) throws MessagingException, UnsupportedEncodingException {
        System.out.println(email);
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("findroommateapp@gmail.com","Find Roommate");
        helper.setTo(email);
        String link = "http://localhost:4200/reset-password/" + resetPasswordToken;

        String subject = "Reset your password";

        String content = "<p>Hello,</p>"
                +"<p>Please access this link in order to reset your password:<p>"
                + "<p><a href=\"" + link + "\">Reset password</a></p>"
                + "<br>";

        helper.setSubject(subject);
        helper.setText(content,true);
        javaMailSender.send(message);
    }


    @Override
    @Transactional
    public String updateImage(Long id, byte[] content, String extension) {
        User user = userRepository.findById(id).orElse(null);
        String image = Base64.encode(content);
        if (user!=null) {
            user.setProfilePhoto(image);
        }
        userRepository.save(user);
        return image;
    }

}
