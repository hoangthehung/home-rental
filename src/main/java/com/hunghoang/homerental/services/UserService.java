package com.hunghoang.homerental.services;

import com.hunghoang.homerental.entities.UsersEntity;
import com.hunghoang.homerental.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> allUsers();
    Optional<User> findByUsername(String username);
}
