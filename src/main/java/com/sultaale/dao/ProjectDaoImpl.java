package com.sultaale.dao;

import com.sultaale.entity.Employee;
import com.sultaale.entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.transaction.Transactional;
import java.util.List;

@Component  // АР: @Repository будет уместнее
public class ProjectDaoImpl implements ProjectDao{
    private final SessionFactory sessionFactory;

    @Autowired
    public ProjectDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Project> getAllProjects(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Project p", Project.class)
                .getResultList();
    }


    @Transactional
    public void save(Project project){
        Session session = sessionFactory.getCurrentSession();
        session.save(project);
    }

    @Transactional
    public List<Employee> getAllEmployeeOnProject(int id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT p FROM Employee p JOIN p.projects r WHERE r.id IN (:projectId)");
        query.setParameter("projectId", id);

        List<Employee> employees = query.getResultList();
        return employees;
    }


    @Transactional
    public void delete(int id){
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Project.class, id));
    }
}
