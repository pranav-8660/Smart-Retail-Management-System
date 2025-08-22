package com.pranavv51.userservice.secure_user_management_service.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(unique = true)
    private String userName;

    private String emailId;

    private Date dateOfBirth;

    private String role; //roles are: admin, user

    private String password;


    public User (String userName,String emailId,Date dateOfBirth, String role){

        this.userName = userName;
        this.emailId = emailId;
        this.dateOfBirth = dateOfBirth;
        this.role = role;

    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
