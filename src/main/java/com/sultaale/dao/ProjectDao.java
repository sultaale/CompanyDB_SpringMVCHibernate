package com.sultaale.dao;

import com.sultaale.entity.Employee;
import com.sultaale.entity.Project;

import java.util.List;

public interface ProjectDao {  // АР: для CRUD нужен update  и delete методы

    public List<Project> getAllProjects();
    public void save(Project project);
    public List<Employee> getAllEmployeeOnProject(int id);
    public void delete(int id);

 }
