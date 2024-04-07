package com.hunghoang.homerental.services;

import com.hunghoang.homerental.entities.UsersEntity;
import com.hunghoang.homerental.mapper.InternalMapper;
import com.hunghoang.homerental.model.User;
import com.hunghoang.homerental.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;
    final InternalMapper internalMapper;
    @Override
    public List<User> allUsers() {

        return userRepository.findAll()
                .stream()
                .map(internalMapper::toUser)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(internalMapper::toUser);
    }

}
