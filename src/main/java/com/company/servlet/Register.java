package com.company.servlet;

import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		if(password.length()<8 || password.length()>8)
		{
			response.sendRedirect("Register.jsp?error=1");
			System.out.println("Password length invalid");
			return;
		}
       
		// System.out.println("parameters"+name+" "+email +" "+password);
		try {
			if(userdao.isExist(name,password)) {
				System.out.println("User already a customer");
				response.sendRedirect("Register.jsp?error=3");
			}
			 else {
				    String code=name.substring(0,3)+password.substring(0,password.length()-3);
				    int map=(int)Math.abs(code.hashCode())%100000;
					userdao.addUser(name,email,password,map); 
					HttpSession ss=request.getSession();
					ss.setAttribute("name",name);
					ss.setAttribute("code",map);
					response.sendRedirect("welcome.jsp?register=1");
			    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in Register Block");
		}
	
	}

}
