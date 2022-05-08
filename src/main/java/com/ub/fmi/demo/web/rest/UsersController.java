package com.ub.fmi.demo.web.rest;

import com.ub.fmi.demo.domain.User;
import com.ub.fmi.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
    @PostMapping("/register")
    public void addUser(@RequestBody User user){
         userService.createUser(user);
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
    @PostMapping("/change-role/{id}")
    public void changeRole(@PathVariable("id") Long id,@RequestBody String[] roleName){
        userService.changeRole(id,roleName[0]);
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
    @PostMapping("/activate-account")
    public void activateAccount(@RequestBody String[] token){
        System.out.println(token[0]);
        userService.activateAccount(token[0]);
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
    @GetMapping("/role/{username}")
    public String getRole(@PathVariable("username") String username){
        return userService.getUserRole(username);
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
    @GetMapping("/user/{username}")
    public User user(@PathVariable("username") String username){
        System.out.println(username);
        return userService.getUserByUsername(username);
    }


    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
    @PutMapping("/{id}/image")
    public String updateImage(@RequestParam MultipartFile imageFile, @PathVariable Long id) {
        System.out.println(imageFile);
        try {
            return userService.updateImage(id, imageFile.getBytes(), imageFile.getOriginalFilename().substring(imageFile.getOriginalFilename().indexOf('.')));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }






}
