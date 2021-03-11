package com.lucy.database;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
  
// This class can be used to initialize the database connection 
public class DatabaseConnection { 
    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException  { 
        String dbDriver = "com.mysql.cj.jdbc.Driver"; 
        String dbURL = "jdbc:mysql://localhost:3306/webdb?characterEncoding=utf8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"; 
        String dbUsername = "webdb"; 
        String dbPassword = "webdb"; 
  
        Class.forName(dbDriver); 
        System.out.println("++driver loaded");
        Connection con = DriverManager.getConnection(dbURL, dbUsername,dbPassword); 
        System.out.println("++connection success");
        return con; 
    } 
} 
