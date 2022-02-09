package com.codegym.casestudy.dto.request;

import lombok.Data;

import java.util.Set;

@Data
public class SignUpForm {
    private String name;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private Set<String> roles;
}
