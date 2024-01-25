package com.company.Dao;

public interface userDao {

      boolean isValid(String user_name, String password);
      boolean isExist(String name,String password);
	 boolean addUser(String name, String email, String password);
}
