package com.fooddeliveryservice.fooddeliveryservice.Repository;

import com.fooddeliveryservice.fooddeliveryservice.Entity.User;

public interface IUserRepository {
    public User findById(int id);
    void save(User user);

}
