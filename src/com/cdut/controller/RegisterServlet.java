package com.qfedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.User;
/**
 * 注册界面的控制类
 * @author jinyu
 *
 */
//loadOnStartup 优先级（越小越优先）
@WebServlet(urlPatterns="/register",loadOnStartup=1)
public class RegisterServlet extends BaseServlet {
	
	//private UserService userService=new UserServiceImpl();
	
	/**
	 * 读取jsp界面输入的信息，并与数据库比较，判断是否能添加入数据库中
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String passwordAgain=req.getParameter("passwordAgain");
		String email=req.getParameter("email");
		//判断输入数据是否符合规范.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")
		if((username!=null)&&(password!=null)&&(password.equals(passwordAgain))&&email.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")) {	
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			//判断是否与数据库已有数据相同
			if(getUserService().register(user)) {
				req.getSession().setAttribute("username", username);
				resp.sendRedirect("dept");
			}else {
				req.setAttribute("hint", "注册失败，请求更改用户名!");
				req.getRequestDispatcher("register.jsp").forward(req, resp);
			}
		}else if(!passwordAgain.equals(password)){
			req.setAttribute("hint", "两次密码输入不一致!");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}else{
			req.setAttribute("hint", "请输入有效的注册信息!");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
	}
	

}
