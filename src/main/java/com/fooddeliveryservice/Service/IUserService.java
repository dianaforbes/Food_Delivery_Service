package com.fooddeliveryservice.Service;

import com.fooddeliveryservice.Entity.User;

public interface IUserService {
    public User findById(int id);
    User save(User user);
}
