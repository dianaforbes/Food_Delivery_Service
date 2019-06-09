package com.fooddeliveryservice.Repository;

import com.fooddeliveryservice.Entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    @Override
    public User findById(int id) {
        User user = null;
//        user = em.find(User.class, id);
        user = sessionFactory.getCurrentSession().find(User.class, id);
        return user;
    }

    @Transactional
    @Cascade(CascadeType.PERSIST)
    public User save(User user) {
        if (user.getId() == 0) {
            sessionFactory.getCurrentSession().persist(user);
        } else {
            sessionFactory.getCurrentSession().merge(user);
        }
        return user;
    }

    //TODO make proper implementation for Spring Security
    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<User> findByIdIn(List<Long> userIds) {
        return null;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Boolean existsByUsername(String username) {
        return null;
    }

    //todo add proper implementation
    @Override
    public Boolean existsByEmail(String email) {
        return false;
    }
}





