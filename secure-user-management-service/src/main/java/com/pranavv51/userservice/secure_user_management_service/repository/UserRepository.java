package com.pranavv51.userservice.secure_user_management_service.repository;

import com.pranavv51.userservice.secure_user_management_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String userName);

}
