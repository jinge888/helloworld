package com.yaolala.dobigthing.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaolala.dobigthing.entity.User;
import com.yaolala.dobigthing.service.UserService;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//创建业务逻辑层对象
    private UserService userService = new UserService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charSet=UTF-8");
		User user = new User();
		String user_name = request.getParameter("user_name");
		String user_pwd = request.getParameter("user_pwd");
		
		user.setName(user_name);
		user.setPwd(user_pwd);
		//添加用户
		boolean flag = userService.addUser(user);
		if (flag == true) {
			//若添加成功，返回用户列表
			 List<User> userList =userService.getAllUser();
			 request.setAttribute("userList", userList);
			 request.getRequestDispatcher("./UserlistServlet").forward(request, response);
		}
	}

}
