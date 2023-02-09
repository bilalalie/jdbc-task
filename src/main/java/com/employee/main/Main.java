package com.employee.main;

import com.employee.controller.EmployeeController;
import com.employee.database.DatabaseConfiguration;
import com.employee.model.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String s ;
        Employee e = new Employee();
        EmployeeController ec = new EmployeeController();
        //ec.addNewEmployee(e);

        //ec.deleteById(2);
        s= ec.getAllEmployees().get(0).getName();
        System.out.println(s);

    }
}
