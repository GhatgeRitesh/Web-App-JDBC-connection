<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<link rel="stylesheet" href="register.css">
</head>
<body>
 <div class="head">
        <div class="name">
           User Registration 
        </div>
    </div>
    <div class="template">
        <div class="form_details">
            <form action="MyServlet" method="post">
                <label for="user_name">User Name :</label>
                <br><input type="text" id="User_Name" name="user_name" required>
                <br><label for="email_id">Email_id :</label>
                <br><input type="text" name="email_id" required>
                <br><label for="password">Password :</label>
                <br><input type="text" name="password" required>
                <br>
                <button>Register</button>
            </form>
            <div class="content">
                <a href="index.html">Return Home</a> <a href="Login.jsp">Login</a>
            </div>
        </div>
    </div>
</body>
</html>