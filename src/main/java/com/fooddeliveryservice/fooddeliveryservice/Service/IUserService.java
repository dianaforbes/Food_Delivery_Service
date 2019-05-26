package com.fooddeliveryservice.fooddeliveryservice.Service;

import com.fooddeliveryservice.fooddeliveryservice.Entity.User;

public interface IUserService {
    public User findById(int id);
    User save(User user);
}
