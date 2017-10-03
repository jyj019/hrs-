package com.qfedu.controller;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet(urlPatterns="/empDetail",loadOnStartup=1)
public class ShowDetailEmpServlet extends BaseServlet {
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {		
	
		Integer EmpNo = Integer.parseInt(req.getParameter("eno"));		
		req.setAttribute("emp",getEmpService().findEmpByEmpNo(EmpNo));
		req.getRequestDispatcher("emp_detail.jsp").forward(req, resp);
		
	}	
}
