package com.lucy.emaillist01.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException  { 
        String dbDriver = "com.mysql.cj.jdbc.Driver"; 
        String dbURL = "jdbc:mysql://localhost:3306/bitServlet?characterEncoding=utf8&serverTimezone=UTC&useSSL=false"; 
        String dbUsername = "root"; 
        String dbPassword = "password"; 
  
        Class.forName(dbDriver); 
        Connection con = DriverManager.getConnection(dbURL, dbUsername,dbPassword); 
        return con; 
    } 

}
