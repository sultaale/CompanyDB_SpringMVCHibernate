package com.sultaale.dao;

import com.sultaale.entity.Employee;
import com.sultaale.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{
    private SessionFactory sessionFactory;

    @Autowired
    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @Transactional
    public List<Role> allRoles() {
        Session session = sessionFactory.getCurrentSession();
        List<Role> roles = session.createQuery("select p from Role p", Role.class).getResultList();
        return roles;
    }

    @Transactional
    public List<Employee> getEmployeeByRole(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from Employee p where p.role.id = :role_Id");
        query.setParameter("role_Id", id);

        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Role.class, id));
    }
}
