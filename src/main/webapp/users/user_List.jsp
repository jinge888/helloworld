<%@page import="com.yaolala.dobigthing.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<%
		List<User> userList = (List<User>) request.getAttribute("userList");
		String listInfo = (String) request.getAttribute("listInfo");
		if (userList == null) {
	%>
	<h3><%=listInfo%></h3>
	<%
		} else {
	%>
	<div>
				    <a href="./UserRegister.jsp">Add User</a>
		<hr />
	</div>
	<table>
		<thead>
			<tr>
				<th>User ID</th>
				<th>User Name</th>
				<th>User Password</th>
				<th>Actions</th>
			</tr>
		</thead>

		<tbody>
			<%
				for (User user : userList) {
						int userId = user.getId();
						String userName = user.getName();
						String userPwd = user.getPwd();
			%>
			<tr>
				<td><%=userId%></td>
				<td><%=userName%></td>
				<td><%=userPwd%></td>
				<td>
				<a href="./EditUserServlet?id=<%=userId%>">Edit</a> 
				<a href="./DeleteUserServlet?id=<%=userId%>">Delete</a></td>
			</tr>
			<%}%>
			<% } %>
		</tbody>
	</table>

</body>
</html>