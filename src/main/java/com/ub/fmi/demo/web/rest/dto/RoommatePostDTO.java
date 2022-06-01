package com.ub.fmi.demo.web.rest.dto;

import com.ub.fmi.demo.domain.RoommatePost;
import com.ub.fmi.demo.domain.User;
import com.ub.fmi.demo.utils.GenderEnum;


public class RoommatePostDTO {

    private Long roommatePostId;

    private boolean smoker;

    private String city;

    private boolean acceptSmoker;

    private GenderEnum roommateGenderPreference;

    private GenderEnum hasGender;

    private Integer hasAge;

    private Integer roommateMinAgePreference;

    private Integer roommateMaxAgePreference;

    private boolean hasApartment;

    private boolean hasPets;

    private boolean acceptPets;

    private boolean working;

    private boolean acceptNotWorking;

    private boolean organized;

    private boolean acceptUnorganized;

    private boolean likesParties;

    private boolean acceptPartyingRoommate;

    private boolean communicative;

    private boolean acceptUncommunicative;

    private boolean patient;

    private boolean acceptNotPatient;

    private boolean friendly;

    private boolean acceptNotFriendly;

    private boolean responsible;

    private boolean acceptNotResponsible;

    private boolean hasHomeParties;

    private boolean acceptHomeParties;

    private boolean hasGuests;

    private boolean acceptGuests;

    private boolean lookingForAFriend;

    private String description;

    private User user;

    public RoommatePostDTO(RoommatePost roommatePost, User user) {
        this.roommatePostId = roommatePost.getRoommatePostId();
        this.smoker = roommatePost.isSmoker();
        this.city = roommatePost.getCity();
        this.acceptSmoker = roommatePost.isAcceptSmoker();
        this.roommateGenderPreference = roommatePost.getRoommateGenderPreference();
        this.hasGender = roommatePost.getHasGender();
        this.hasAge = roommatePost.getHasAge();
        this.roommateMinAgePreference = roommatePost.getRoommateMinAgePreference();
        this.roommateMaxAgePreference = roommatePost.getRoommateMaxAgePreference();
        this.hasApartment = roommatePost.isHasApartment();
        this.hasPets = roommatePost.isHasPets();
        this.acceptPets = roommatePost.isAcceptPets();
        this.working = roommatePost.isWorking();
        this.acceptNotWorking = roommatePost.isAcceptNotWorking();
        this.organized = roommatePost.isOrganized();
        this.acceptUnorganized = roommatePost.isAcceptUnorganized();
        this.likesParties = roommatePost.isLikesParties();
        this.acceptPartyingRoommate = roommatePost.isAcceptPartyingRoommate();
        this.communicative = roommatePost.isCommunicative();
        this.acceptUncommunicative = roommatePost.isCommunicative();
        this.patient = roommatePost.isPatient();
        this.acceptNotPatient = roommatePost.isAcceptNotPatient();
        this.friendly = roommatePost.isFriendly();
        this.acceptNotFriendly = roommatePost.isAcceptNotFriendly();
        this.responsible = roommatePost.isResponsible();
        this.acceptNotResponsible = roommatePost.isAcceptNotResponsible();
        this.hasHomeParties = roommatePost.isHasHomeParties();
        this.acceptHomeParties = roommatePost.isAcceptHomeParties();
        this.hasGuests = roommatePost.isHasGuests();
        this.acceptGuests = roommatePost.isAcceptGuests();
        this.lookingForAFriend = roommatePost.isLookingForAFriend();
        this.description = roommatePost.getDescription();
        this.user = user;
    }

    public Long getRoommatePostId() {
        return roommatePostId;
    }

    public void setRoommatePostId(Long roommatePostId) {
        this.roommatePostId = roommatePostId;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isAcceptSmoker() {
        return acceptSmoker;
    }

    public void setAcceptSmoker(boolean acceptSmoker) {
        this.acceptSmoker = acceptSmoker;
    }

    public GenderEnum getRoommateGenderPreference() {
        return roommateGenderPreference;
    }

    public void setRoommateGenderPreference(GenderEnum roommateGenderPreference) {
        this.roommateGenderPreference = roommateGenderPreference;
    }

    public GenderEnum getHasGender() {
        return hasGender;
    }

    public void setHasGender(GenderEnum hasGender) {
        this.hasGender = hasGender;
    }

    public Integer getHasAge() {
        return hasAge;
    }

    public void setHasAge(Integer hasAge) {
        this.hasAge = hasAge;
    }

    public Integer getRoommateMinAgePreference() {
        return roommateMinAgePreference;
    }

    public void setRoommateMinAgePreference(Integer roommateMinAgePreference) {
        this.roommateMinAgePreference = roommateMinAgePreference;
    }

    public Integer getRoommateMaxAgePreference() {
        return roommateMaxAgePreference;
    }

    public void setRoommateMaxAgePreference(Integer roommateMaxAgePreference) {
        this.roommateMaxAgePreference = roommateMaxAgePreference;
    }

    public boolean isHasApartment() {
        return hasApartment;
    }

    public void setHasApartment(boolean hasApartment) {
        this.hasApartment = hasApartment;
    }

    public boolean isHasPets() {
        return hasPets;
    }

    public void setHasPets(boolean hasPets) {
        this.hasPets = hasPets;
    }

    public boolean isAcceptPets() {
        return acceptPets;
    }

    public void setAcceptPets(boolean acceptPets) {
        this.acceptPets = acceptPets;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public boolean isAcceptNotWorking() {
        return acceptNotWorking;
    }

    public void setAcceptNotWorking(boolean acceptNotWorking) {
        this.acceptNotWorking = acceptNotWorking;
    }

    public boolean isOrganized() {
        return organized;
    }

    public void setOrganized(boolean organized) {
        this.organized = organized;
    }

    public boolean isAcceptUnorganized() {
        return acceptUnorganized;
    }

    public void setAcceptUnorganized(boolean acceptUnorganized) {
        this.acceptUnorganized = acceptUnorganized;
    }

    public boolean isLikesParties() {
        return likesParties;
    }

    public void setLikesParties(boolean likesParties) {
        this.likesParties = likesParties;
    }

    public boolean isAcceptPartyingRoommate() {
        return acceptPartyingRoommate;
    }

    public void setAcceptPartyingRoommate(boolean acceptPartyingRoommate) {
        this.acceptPartyingRoommate = acceptPartyingRoommate;
    }

    public boolean isCommunicative() {
        return communicative;
    }

    public void setCommunicative(boolean communicative) {
        this.communicative = communicative;
    }

    public boolean isAcceptUncommunicative() {
        return acceptUncommunicative;
    }

    public void setAcceptUncommunicative(boolean acceptUncommunicative) {
        this.acceptUncommunicative = acceptUncommunicative;
    }

    public boolean isPatient() {
        return patient;
    }

    public void setPatient(boolean patient) {
        this.patient = patient;
    }

    public boolean isAcceptNotPatient() {
        return acceptNotPatient;
    }

    public void setAcceptNotPatient(boolean acceptNotPatient) {
        this.acceptNotPatient = acceptNotPatient;
    }

    public boolean isFriendly() {
        return friendly;
    }

    public void setFriendly(boolean friendly) {
        this.friendly = friendly;
    }

    public boolean isAcceptNotFriendly() {
        return acceptNotFriendly;
    }

    public void setAcceptNotFriendly(boolean acceptNotFriendly) {
        this.acceptNotFriendly = acceptNotFriendly;
    }

    public boolean isResponsible() {
        return responsible;
    }

    public void setResponsible(boolean responsible) {
        this.responsible = responsible;
    }

    public boolean isAcceptNotResponsible() {
        return acceptNotResponsible;
    }

    public void setAcceptNotResponsible(boolean acceptNotResponsible) {
        this.acceptNotResponsible = acceptNotResponsible;
    }

    public boolean isHasHomeParties() {
        return hasHomeParties;
    }

    public void setHasHomeParties(boolean hasHomeParties) {
        this.hasHomeParties = hasHomeParties;
    }

    public boolean isAcceptHomeParties() {
        return acceptHomeParties;
    }

    public void setAcceptHomeParties(boolean acceptHomeParties) {
        this.acceptHomeParties = acceptHomeParties;
    }

    public boolean isHasGuests() {
        return hasGuests;
    }

    public void setHasGuests(boolean hasGuests) {
        this.hasGuests = hasGuests;
    }

    public boolean isAcceptGuests() {
        return acceptGuests;
    }

    public void setAcceptGuests(boolean acceptGuests) {
        this.acceptGuests = acceptGuests;
    }

    public boolean isLookingForAFriend() {
        return lookingForAFriend;
    }

    public void setLookingForAFriend(boolean lookingForAFriend) {
        this.lookingForAFriend = lookingForAFriend;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
