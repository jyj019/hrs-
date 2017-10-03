package com.qfedu.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录页面的控制类
 * @author Administrator
 *
 */
@WebServlet(urlPatterns="/login",loadOnStartup=1)
public class LoginServlet extends BaseServlet {
	
	//private UserService userService=new UserServiceImpl();
	/**	
	 * 读取jsp界面输入的信息，并与数据库比较，判断是否能登录
	 */
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		//判断输入数据是否符合规范
		if(username!=null&&password!=null) {
			//判断是否与数据库内数据匹配
			if(getUserService().login(username, password)) {
				req.getSession().setAttribute("username", username);
				resp.sendRedirect("dept");
			}else {
				req.setAttribute("hint", "用户名或密码错误!");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		}else {
			req.setAttribute("hint", "请输入有效的登录信息!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
	}
	
}
