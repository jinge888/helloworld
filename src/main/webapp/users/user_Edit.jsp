<%@page import="com.yaolala.dobigthing.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑用户</title>
</head>
<body>
<%
User user =(User) request.getAttribute("user_Edit");
%>
<form action="./UpdateUserServlet" method="get">
<!-- 用户ID -->
<div>
<input type="text" name="user_Id" placeholder="<%=user.getId()%>"/>
</div>
<!-- 用户名 -->
<div>
<input type="text" name="user_Name" required="required" placeholder="Enter New UserName">
</div>
<!-- 用户密码 -->
<div class="form-group">
 <input type="text" name="user_pwd" required="required" placeholder="Enter New Password" />
</div>

<div>
<button type="submit">保存更改</button>
</div>
</form>

</body>
</html>