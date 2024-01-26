<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="jakarta.servlet.http.HttpSession"    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Last Page</title>
<link rel="stylesheet" href="welcome.css">
</head>
<body>
<div class="head">
    Application user Interface page 
   </div> 
   <div class="template">
   <% // retrive the session 
     HttpSession ss=request.getSession(false);
     String name=" ";
	 int code=0;
     // check the session isvalid or have errors
     if(ss !=null && ss.getAttribute("name")!=null && ss.getAttribute("code")!=null)
     {
    	  name=(String)ss.getAttribute("name");
    	  code=(int)ss.getAttribute("code");
     }
   %>
    <h1>Hello, <%= name %>!</h1>
    <h2>here is your UserId <%= code %></h2>
     welcome to the project's last page
     <br>
     here we have successfully created the user account 
     <br>
     we can use this User Authentification pages <br> for the secure Account verification 
     <br>
     the project can further be used to develope various purposes
     <br>
     <br>
     <a href="index.html">Signout Securely !</a>
   </div>
</body>
</html>