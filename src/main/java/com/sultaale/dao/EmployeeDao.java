package com.sultaale.dao;

import com.sultaale.entity.Employee;
import java.util.List;


public interface EmployeeDao {
    public List<Employee> getEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployee(int id);
}
