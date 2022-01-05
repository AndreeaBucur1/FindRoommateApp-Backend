package com.ub.fmi.demo.service;

import javax.naming.AuthenticationException;

public interface AuthenticationService {

    boolean authenticate(String username, String password) throws AuthenticationException;


}
