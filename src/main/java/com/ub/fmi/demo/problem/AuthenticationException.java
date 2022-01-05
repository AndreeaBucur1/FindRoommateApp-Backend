package com.ub.fmi.demo.problem;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class AuthenticationException extends AbstractThrowableProblem {

    private static final long serialVersionUID = -6912353366402841165L;
    private static final URI TYPE = URI.create("https://accenture.org/authentication-exception");

    public AuthenticationException() {
        super(TYPE, "Authentication exception", Status.UNAUTHORIZED, "Wrong credentials");
    }
}
