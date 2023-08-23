package com.sultaale.dao;

import com.sultaale.entity.Employee;
import com.sultaale.entity.Role;

import java.util.List;

public interface RoleDao {
    public List<Role> allRoles();
    public List<Employee> getEmployeeByRole(int id);
    public  void delete(int id);

}
