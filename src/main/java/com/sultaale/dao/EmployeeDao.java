package com.sultaale.dao;

import com.sultaale.entity.Employee;
import java.util.List;


public interface EmployeeDao { // АР: для CRUD нужен update  и delete методы
    public List<Employee> getEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployee(int id);
}
