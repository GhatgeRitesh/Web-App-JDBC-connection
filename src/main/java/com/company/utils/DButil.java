package com.company.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	private static final String url="jdbc:mysql://localhost:3306/Register";
	private static final String password="Rit!@#1115";
	private static final String username="root";
	 static {
	        try {
	            // Load the MySQL JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	public static Connection getconnection() throws SQLException {
		
        Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
        
         }
}
