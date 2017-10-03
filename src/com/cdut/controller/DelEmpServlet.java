package com.qfedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 删除员工的控制类
 * @author jinyu
 *
 */
@WebServlet(urlPatterns="/delEmp",loadOnStartup = 1)
public class DelEmpServlet extends BaseServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noString = req.getParameter("eno");
		if (noString != null) {
			int no = Integer.parseInt(noString);
			String responseText =
					getEmpService().removeEmpByNo(no)?"success":"failed";
			PrintWriter pw=resp.getWriter();
			pw.write(responseText);
			pw.close();
		}
		
	}
}
