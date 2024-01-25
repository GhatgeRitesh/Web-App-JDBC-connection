<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link rel="stylesheet" href="Login.css">
</head>
<body>
      <div class="head">
          <div class="name">
          User Login 
          </div>
    </div>
    <div class="template">
        <div class="content">
         Enter your details 
        </div>
        <div class="form_details">
            <form action="MyServlet" method="post">
                <label for="Name">Name:</label><br>
                <input type="text" id="UserName" name="Name" required><br>
                <label for="UserID">User_Id:</label><br>
                <input type="text" name="UserID" id="UserId" required><br>
                <label for="password">Password:</label><br>
                <input type="text" name="password" id="password" required><br>
                <button>Login</button>
            </form>
        </div>
        <div class="userauth">
            Forgot Password <a href="Password">click here!</a><br>
            <a href="index.html">Return Home </a>OR New User <a href="Register.jsp">Register</a>
        </div>
           <%-- Display error message if login fails --%>
        <% String error = request.getParameter("error");
            if (error != null && error.equals("1")) { %>
                <p style="color: red;">Invalid username or password. Please try again.</p>
        <% } %>
    </div>
</body>
</html>