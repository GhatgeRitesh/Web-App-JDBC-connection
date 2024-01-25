package com.company.servlet;

import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.company.Dao.userDao;
import com.company.Dao.userDaoImpl;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static userDao userdao= new userDaoImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  // code for the new user registration
		String name=request.getParameter("user_name");
		String email=request.getParameter("email_id");
		String password=request.getParameter("password");
		System.out.println("parameters"+name+" "+email +" "+password);
		try {
			if(userdao.isExist(name,password)) {
				System.out.println("User already a customer");
			}
			 else {
			        response.sendRedirect("login.jsp?error=2");
			    	System.out.println("Error A gya");
			    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userdao.addUser(name,email,password);
	}

}
