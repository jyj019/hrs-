package com.qfedu.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��¼ҳ��Ŀ�����
 * @author Administrator
 *
 */
@WebServlet(urlPatterns="/login",loadOnStartup=1)
public class LoginServlet extends BaseServlet {
	
	//private UserService userService=new UserServiceImpl();
	/**	
	 * ��ȡjsp�����������Ϣ���������ݿ�Ƚϣ��ж��Ƿ��ܵ�¼
	 */
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		//�ж����������Ƿ���Ϲ淶
		if(username!=null&&password!=null) {
			//�ж��Ƿ������ݿ�������ƥ��
			if(getUserService().login(username, password)) {
				req.getSession().setAttribute("username", username);
				resp.sendRedirect("dept");
			}else {
				req.setAttribute("hint", "�û������������!");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		}else {
			req.setAttribute("hint", "��������Ч�ĵ�¼��Ϣ!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
	}
	
}
