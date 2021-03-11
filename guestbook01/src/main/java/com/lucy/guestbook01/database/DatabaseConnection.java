package com.lucy.guestbook01.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public static Connection initializeDatabase() throws Exception{ 
            String dbDriver = "com.mysql.cj.jdbc.Driver"; 
            String dbURL = "jdbc:mysql://localhost:3306/webdb?characterEncoding=utf8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"; 
            String dbUsername = "webdb"; 
            String dbPassword = "webdb"; 
            Class.forName(dbDriver); 
            System.out.println("*db loaded*");
            Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword); 
            System.out.println("*db connected*");
            return con; 
	}
}
