package com.sultaale.dao;


import com.sultaale.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Employee> getEmployees() {
        Session session  = sessionFactory.getCurrentSession();
        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
        System.out.println(allEmployees.size());
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return null;
    }
}
