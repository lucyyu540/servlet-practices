package com.lucy.database;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
  
// This class can be used to initialize the database connection 
public class DatabaseConnection { 
    public static Connection initializeDatabase() 
        throws SQLException, ClassNotFoundException 
    { 
        // Initialize all the information regarding 
        // Database Connection 
        String dbDriver = "com.mysql.cj.jdbc.Driver"; 
        String dbURL = "jdbc:mysql://localhost:3306/bitServlet?characterEncoding=utf8&serverTimezone=UTC&useSSL=false"; 
        // Database name to access 
        String dbUsername = "root"; 
        String dbPassword = "password"; 
  
        Class.forName(dbDriver); 
        Connection con = DriverManager.getConnection(dbURL, 
                                                     dbUsername,  
                                                     dbPassword); 
        return con; 
    } 
} 
