package com.sultaale.dao;

import com.sultaale.entity.Employee;
import com.sultaale.entity.Role;

import java.util.List;

public interface RoleDao { // АР: для CRUD нужен create, update методы
    public List<Role> allRoles();
    public List<Employee> getEmployeeByRole(int id); // AP: этот метод с List <Employee> я бы отнес к EmployeeDao
    public  void delete(int id);

}
