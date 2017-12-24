<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
<form action="./UserLoginServlet"  name="loginForm"  method="post">
<div>
 <input type="text" id="user_login" name="userId" required="required" placeholder="User ID">
</div>
<div>
 <input type="password" id="user_pwd" name="userPassword" required="required" placeholder="Your Password">
</div>
<input type="submit" value="login"/>
</form>
<a href="./UserRegister.jsp">
<span>New User Register</span>
</a>
</body>
</html>