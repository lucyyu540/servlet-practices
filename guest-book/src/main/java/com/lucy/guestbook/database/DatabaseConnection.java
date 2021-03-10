package com.lucy.guestbook.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public static Connection initializeDatabase() throws Exception{ 
            String dbDriver = "com.mysql.cj.jdbc.Driver"; 
            String dbURL = "jdbc:mysql://localhost:3306/bitServlet?characterEncoding=utf8&serverTimezone=UTC&useSSL=false"; 
            String dbUsername = "root"; 
            String dbPassword = "password"; 
            Class.forName(dbDriver); 
            System.out.println("*db loaded*");
            Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword); 
            System.out.println("*db connected*");
            return con; 
	}
}
