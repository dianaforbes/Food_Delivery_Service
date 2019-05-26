package com.fooddeliveryservice.Service;

import com.fooddeliveryservice.Entity.User;
import com.fooddeliveryservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Transactional
    public User save(User user) {

        userRepository.save(user);

        return user;

    }

}

