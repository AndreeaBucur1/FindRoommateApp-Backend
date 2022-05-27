package com.ub.fmi.demo.domain;

import com.ub.fmi.demo.utils.GenderEnum;

import javax.persistence.*;

@Entity
@Table(name="roommate_post")
public class RoommatePost {

    @Id
    @GeneratedValue
    @Column(name = "roommate_post_id")
    private Long roommatePostId;

    @Column
    private boolean isSmoker;

    @Column
    private String city;

    @Column
    private boolean acceptSmoker;

    @Column
    private GenderEnum roommateGenderPreference;

    @Column
    private GenderEnum hasGender;

    @Column
    private Integer hasAge;

    @Column
    private Integer roommateMinAgePreference;

    @Column
    private Integer roommateMaxAgePreference;

    @Column
    private boolean hasApartment;

    @Column
    private boolean hasPets;

    @Column
    private boolean acceptPets;

    @Column
    private boolean isWorking;

    @Column
    private boolean acceptNotWorking;

    @Column
    private boolean isOrganized;

    @Column
    private boolean acceptUnorganized;

    @Column
    private boolean likesParties;

    @Column
    private boolean acceptPartyingRoommate;

    @Column
    private boolean isCommunicative;

    @Column
    private boolean acceptUncommunicative;

    @Column
    private boolean isPatient;

    @Column
    private boolean acceptNotPatient;

    @Column
    private boolean isFriendly;

    @Column
    private boolean acceptNotFriendly;

    @Column
    private boolean isResponsible;

    @Column
    private boolean acceptNotResponsible;

    @Column
    private boolean hasHomeParties;

    @Column
    private boolean acceptHomeParties;

    @Column
    private boolean hasGuests;

    @Column
    private boolean acceptGuests;

    @Column
    private boolean isLookingForAFriend;

    @Column
    private String description;

    public Long getRoommatePostId() {
        return roommatePostId;
    }

    public void setRoommatePostId(Long roommatePostId) {
        this.roommatePostId = roommatePostId;
    }

    public boolean isSmoker() {
        return isSmoker;
    }

    public void setSmoker(boolean smoker) {
        isSmoker = smoker;
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
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public boolean isAcceptNotWorking() {
        return acceptNotWorking;
    }

    public void setAcceptNotWorking(boolean acceptNotWorking) {
        this.acceptNotWorking = acceptNotWorking;
    }

    public boolean isOrganized() {
        return isOrganized;
    }

    public void setOrganized(boolean organized) {
        isOrganized = organized;
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
        return isCommunicative;
    }

    public void setCommunicative(boolean communicative) {
        isCommunicative = communicative;
    }

    public boolean isAcceptUncommunicative() {
        return acceptUncommunicative;
    }

    public void setAcceptUncommunicative(boolean acceptUncommunicative) {
        this.acceptUncommunicative = acceptUncommunicative;
    }

    public boolean isPatient() {
        return isPatient;
    }

    public void setPatient(boolean patient) {
        isPatient = patient;
    }

    public boolean isAcceptNotPatient() {
        return acceptNotPatient;
    }

    public void setAcceptNotPatient(boolean acceptNotPatient) {
        this.acceptNotPatient = acceptNotPatient;
    }

    public boolean isFriendly() {
        return isFriendly;
    }

    public void setFriendly(boolean friendly) {
        isFriendly = friendly;
    }

    public boolean isAcceptNotFriendly() {
        return acceptNotFriendly;
    }

    public void setAcceptNotFriendly(boolean acceptNotFriendly) {
        this.acceptNotFriendly = acceptNotFriendly;
    }

    public boolean isResponsible() {
        return isResponsible;
    }

    public void setResponsible(boolean responsible) {
        isResponsible = responsible;
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
        return isLookingForAFriend;
    }

    public void setLookingForAFriend(boolean lookingForAFriend) {
        isLookingForAFriend = lookingForAFriend;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
