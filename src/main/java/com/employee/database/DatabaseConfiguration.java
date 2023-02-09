package com.employee.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {

    private static Connection con = null;
    private static String url = "jdbc:mysql://localhost:3306/employee_system?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String pass = "2042001";


    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
