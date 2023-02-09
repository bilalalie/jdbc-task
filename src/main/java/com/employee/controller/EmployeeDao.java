package com.employee.controller;

import com.employee.model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    void addNewEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteById(int id);
}
