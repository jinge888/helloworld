package com.yaolala.dobigthing.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaolala.dobigthing.entity.User;
import com.yaolala.dobigthing.service.ILoginService;
import com.yaolala.dobigthing.service.UserService;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userservice = new UserService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  
        response.setContentType("text/html; charset=utf-8");  
        String path = request.getContextPath();  
        PrintWriter out = response.getWriter();  
        //获取页面输入参数
        int userId =Integer.parseInt(request.getParameter("userId"));  
        String userPwd = request.getParameter("userPassword"); 
        
        User user = userservice.getUser(userId, userPwd);
      //以获取到的请求参数为值，创建Cookie对象
        Cookie cookie =new Cookie("userId",Integer.toString(userId));
        //设置cookie对象的生存期限
        cookie.setMaxAge(24*3600);
        List<Object> params = new ArrayList<Object>();  
        params.add(userId);  
        params.add(userPwd);  
             
        response.sendRedirect(path + "/index.jsp");  

        
	}

}
