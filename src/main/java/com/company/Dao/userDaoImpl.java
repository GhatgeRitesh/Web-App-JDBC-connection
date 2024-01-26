package com.company.Dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.utils.DButil;

public class userDaoImpl implements userDao {
     
	 public  boolean isValid(String user_name, String password) {
		String query="select * from register Where Name=? && Password=?";
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

	public boolean isExist(String name, String password){
	try {	// TODO Auto-generated method stub
	   String query="select * from register Where name =? && password =?";
	   Connection conn=DButil.getconnection();
	   PreparedStatement prepareStatement=conn.prepareStatement(query);
	   prepareStatement.setString(1,name);
	   prepareStatement.setString(2,password);
	   
	   ResultSet result=prepareStatement.executeQuery();
	   
	   return result.next();
	   
	}catch(SQLException e) {
 	   System.out.println(e);
 	   return false;
      }
	}
	public boolean addUser(String name,String email ,String password,String code) {
          try {
        	String query="insert into register(Name,Email,password,code) Values(?,?,?,?)";
			Connection conn=DButil.getconnection();
			PreparedStatement prepareStatement=conn.prepareStatement(query);
			prepareStatement.setString(1,name);
			prepareStatement.setString(2,email);
			prepareStatement.setString(3,password);
			prepareStatement.setString(4,code);
			prepareStatement.executeUpdate();
			System.out.println("succesfully Registered");
			
		    return isValid(name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("bla bla bla");
			return false;
		}
          
		
		
	}

}
