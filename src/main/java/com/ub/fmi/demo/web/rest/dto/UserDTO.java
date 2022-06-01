package com.ub.fmi.demo.web.rest.dto;

import com.ub.fmi.demo.domain.RoommatePost;
import com.ub.fmi.demo.utils.GenderEnum;

public class UserDTO {

    private Long userId;

    private  String email;

    private String firstName;

    private String lastName;

    private String profilePhoto;

    private String role;

    private String username;

    private String phoneNumber;

    private GenderEnum gender;

    private RoommatePost roommatePost;

    public UserDTO(Long id, String email, String firstName, String lastName, String profilePhoto, String role, String username, String phoneNumber, GenderEnum gender, RoommatePost roommatePost) {
        this.userId = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePhoto = profilePhoto;
        this.role = role;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.roommatePost = roommatePost;
    }

    public RoommatePost getRoommatePost() {
        return roommatePost;
    }

    public void setRoommatePost(RoommatePost roommatePost) {
        this.roommatePost = roommatePost;
    }

    public Long getUserId() {
        return userId;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
