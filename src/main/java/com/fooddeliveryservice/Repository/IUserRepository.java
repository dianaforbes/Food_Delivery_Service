package com.fooddeliveryservice.Repository;

import com.fooddeliveryservice.Entity.User;

public interface IUserRepository {
    public User findById(int id);
    void save(User user);

}
