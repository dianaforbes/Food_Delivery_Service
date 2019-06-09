package com.fooddeliveryservice.Repository;

import com.fooddeliveryservice.Entity.Role;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class RoleRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Optional<Role> findByName(String name) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(String.class);
        Role role = (Role) criteria.add(Restrictions.eq("role", name))
                .uniqueResult();
//        Role role = sessionFactory.getCurrentSession().find(Role.class, name);
        return Optional.ofNullable(role);
    }
}
