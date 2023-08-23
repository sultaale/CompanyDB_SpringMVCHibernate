package com.sultaale.service;

import com.sultaale.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployee(int id);
    public Employee delete(int id);
}
