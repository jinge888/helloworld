package com.yaolala.dobigthing.servlet.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaolala.dobigthing.entity.User;
import com.yaolala.dobigthing.service.UserService;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService = new UserService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		/**
		 * 获取修改后的值
		 */
		String userName = request.getParameter("user_Name");
		String userPwd = request.getParameter("user_pwd");
		int userId =Integer.parseInt(request.getParameter("user_Id"));
		/**
		 * 封装修改后的对象，交给业务逻辑层修改
		 */
		User user = new User(userId,userName,userPwd);
		boolean result = userService.updateUser(user);
		String edit_info ="用户信息修改成功！";
		if (!result) {
			edit_info="更新操作失败！！！";
		}
		request.setAttribute("edit_info", edit_info);
		request.getRequestDispatcher("./UserlistServlet").forward(request, response);
	}

}
