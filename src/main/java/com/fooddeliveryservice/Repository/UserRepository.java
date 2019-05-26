package com.fooddeliveryservice.Repository;

import com.fooddeliveryservice.Entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class UserRepository implements IUserRepository {
    @Autowired
    SessionFactory sessionFactory;
    private EntityManager em;

    @Transactional
    @Override
    public User findById(int id) {
        User user = null;
//        user = em.find(User.class, id);
        user = sessionFactory.getCurrentSession().find(User.class, id);
        return user;
    }

    public void save(User user) {

        if (user.getId() == 0) {
            sessionFactory.getCurrentSession().persist(user);
        } else {
            sessionFactory.getCurrentSession().merge(user);
        }
    }
}

