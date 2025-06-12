package com.example.demo.security.dtos;


import java.util.Set;

public class AuthResponseDTO {
    private String jwt;
    private Set<String> roles;
    private Long userId;

    public String getJwt() { return jwt; }
    public void setJwt(String jwt) { this.jwt = jwt; }

    public Set<String> getRoles() { return roles; }
    public void setRoles(Set<String> roles) { this.roles = roles; }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}