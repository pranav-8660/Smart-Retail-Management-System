package com.pranavv51.userservice.secure_user_management_service.DTO;

public class AuthRequest {

    private String username;
    private String password;

    public AuthRequest(String username,String password){
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
