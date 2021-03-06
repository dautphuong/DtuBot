package com.dtubot.entity.security.login_msg.response;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    private String userId;

    private String token;

    private String username;


    private Collection<? extends GrantedAuthority> authorities;


    public JwtResponse() {
    }

    public JwtResponse(String userId, String token, String username, Collection<?
            extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.token = token;
        this.username = username;
        this.authorities = authorities;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
