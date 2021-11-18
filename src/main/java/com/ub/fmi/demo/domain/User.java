package com.ub.fmi.demo.domain;


import javax.persistence.*;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String username;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinTable()
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isAccountActivated() {
        return accountActivated;
    }

    public void setAccountActivated(boolean accountActivated) {
        this.accountActivated = accountActivated;
    }

    private boolean accountActivated;

    private String activationToken;


    public boolean getAccountActivated() {
        return accountActivated;
    }

    public void setAccountActivated(Boolean accountActivated) {
        this.accountActivated = accountActivated;
    }

    public String getActivationToken() {
        return activationToken;
    }

    public void setActivationToken(String activationToken) {
        this.activationToken = activationToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
