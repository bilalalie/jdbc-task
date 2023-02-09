package com.employee.controller;

import com.employee.database.DatabaseConfiguration;
import com.employee.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmployeeController implements EmployeeDao {

    String query;

    @Override
    public List<Employee> getAllEmployees() {
        Connection con = DatabaseConfiguration.getConnection();
        if (con == null) {
            return null;
        }

        List<Employee> employees = new ArrayList<>();

        query = "select * from employee";
        try (PreparedStatement p = con.prepareStatement(query)) {
            ResultSet resultSet = p.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("phone_number"),
                        resultSet.getBoolean("male"), resultSet.getDouble("salary"));

                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Connection con = DatabaseConfiguration.getConnection();

        query = "select * from employee where id = ?";


        try (PreparedStatement p = con.prepareStatement(query)) {
            p.setInt(1, id);
            ResultSet resultSet = p.executeQuery();

            if (resultSet.next()) {
                return new Employee(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("phone_number"),
                        resultSet.getBoolean("male"), resultSet.getDouble("salary"));

            }
            p.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void addNewEmployee(Employee employee) {
        Connection con = DatabaseConfiguration.getConnection();
        if (con == null) {
            return;
        }
        query = "insert into employee (id, name, phone_number, male, salary) values (?, ? , ?, ? ,?)";
        try (PreparedStatement p = con.prepareStatement(query)) {

            p.setInt(1, employee.getId());
            p.setString(2, employee.getName());
            p.setString(3, employee.getPhoneNumber());
            p.setBoolean(4, employee.isMale());
            p.setDouble(5, employee.getSalary());

            p.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateEmployee(Employee employee) {
        Connection con = DatabaseConfiguration.getConnection();
        if (con == null) {
            return;
        }
        query = "update employee set name = ? , phone_number =?, male=?, salary=?  where id = ?";
        try (PreparedStatement p = con.prepareStatement(query)) {

            p.setString(1, employee.getName());
            p.setString(2, employee.getPhoneNumber());
            p.setBoolean(3, employee.isMale());
            p.setDouble(4, employee.getSalary());
            p.setInt(5, employee.getId());
            p.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        Connection con = DatabaseConfiguration.getConnection();

        if (con == null) return;

        query = "delete from employee where id = ?";

        try (PreparedStatement p = con.prepareStatement(query)) {

            p.setInt(1, id);
            p.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
