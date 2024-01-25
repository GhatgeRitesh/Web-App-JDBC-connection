package com.company.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.utils.DButil;

public class userDaoImpl implements userDao {

	@Override
	public boolean isValid(String user_name, String password) {
		String query="select * from user Where Name=? && Password=?";
		try {
			Connection conn=DButil.getconnection();
			PreparedStatement prepareStatement=conn.prepareStatement(query);
			prepareStatement.setString(1,user_name);
			prepareStatement.setString(2,password);
			
			ResultSet resultset=prepareStatement.executeQuery();
			return resultset.next();
		    }
       catch(SQLException e) {
    	   System.out.println(e);
    	   return false;
       }
	}

}
