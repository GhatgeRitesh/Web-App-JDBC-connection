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
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static userDao userdao=new userDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// code for the authentification of the user
		String name=request.getParameter("Name");
		String password=request.getParameter("password");
		char[] c=new char[name.lenght()];
		for(int i=0;i<name.length();i++)
		{
			c[i]=name.charAt(i);
			if(c[i]<64 && c[i]>117)
			{
				error(name);
			}
		}
	
				if(userdao.isValid(name,password))
				{
					HttpSession session=request.getSession();
					session.setAttribute("name",name);
					response.sendRedirect("welcome.jsp?log=1");
					System.out.println("Hi -> "+name);
				}
				else {
					response.sendRedirect("Login.jsp?error=2");
					System.out.println("user input invalid in  Login java");
				}
			} 
			public void error(String name){
			  response.sendRedirect("Login.jsp?error=3");
			  System.out.println("error in name typing");
			}
	}


