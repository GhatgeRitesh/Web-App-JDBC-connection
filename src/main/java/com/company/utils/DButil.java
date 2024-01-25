package com.company.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	private static final String url="jdbc:mysql://localhost:3306/userauth";
	private static final String password="Rit!@#1115";
	private static final String username="root";
	 static {
	        try {
	            // Load the MySQL JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            System.out.println("problem");
	        }
	    }
	public static Connection getconnection() throws SQLException {
		System.out.println("connection establishing");
        
		return DriverManager.getConnection(url,username,password);
        
         }
}
