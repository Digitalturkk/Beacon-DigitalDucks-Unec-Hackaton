package com.beacon.Users.Services;

import com.beacon.Users.User;
import com.beacon.Users.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);

    User update(Long id, User user);

    Optional<User> getById(Long id);

    Optional<User> getByEmail(String email);

    List<User> getAll();

    void deleteById(Long id);

    boolean existsById(Long id);

    boolean existsByEmail(String email);

    // DTO methods
    UserDTO getDtoById(Long id);

    List<UserDTO> getAllDtos();
}