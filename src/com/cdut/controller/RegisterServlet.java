package com.qfedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.User;
/**
 * ע�����Ŀ�����
 * @author jinyu
 *
 */
//loadOnStartup ���ȼ���ԽСԽ���ȣ�
@WebServlet(urlPatterns="/register",loadOnStartup=1)
public class RegisterServlet extends BaseServlet {
	
	//private UserService userService=new UserServiceImpl();
	
	/**
	 * ��ȡjsp�����������Ϣ���������ݿ�Ƚϣ��ж��Ƿ�����������ݿ���
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String passwordAgain=req.getParameter("passwordAgain");
		String email=req.getParameter("email");
		//�ж����������Ƿ���Ϲ淶.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")
		if((username!=null)&&(password!=null)&&(password.equals(passwordAgain))&&email.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")) {	
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			//�ж��Ƿ������ݿ�����������ͬ
			if(getUserService().register(user)) {
				req.getSession().setAttribute("username", username);
				resp.sendRedirect("dept");
			}else {
				req.setAttribute("hint", "ע��ʧ�ܣ���������û���!");
				req.getRequestDispatcher("register.jsp").forward(req, resp);
			}
		}else if(!passwordAgain.equals(password)){
			req.setAttribute("hint", "�����������벻һ��!");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}else{
			req.setAttribute("hint", "��������Ч��ע����Ϣ!");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
	}
	

}
