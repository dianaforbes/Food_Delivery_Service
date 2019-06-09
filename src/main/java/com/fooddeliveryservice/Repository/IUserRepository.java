package com.fooddeliveryservice.Repository;

import com.fooddeliveryservice.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository {
    public User findById(int id);
    User save(User user);
    Optional<User> findByEmail(String email);
    List<User> findByIdIn(List<Long> userIds);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
