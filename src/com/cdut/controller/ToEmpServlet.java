package com.qfedu.controller;


import javax.servlet.annotation.WebServlet;

import com.qfedu.domain.Dept;

@WebServlet(urlPatterns="/toEmp",loadOnStartup=1)
public class ToEmpServlet extends BaseServlet {
	@Override
	protected void service(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		Dept dept=(Dept)req.getSession().getAttribute("dept");
		Integer deptNo = Integer.parseInt(req.getParameter("dno"));
		//int deptNo = Integer.parseInt(req.getParameter("dno"));
		//System.out.println(deptNo+"-debug-"+dept.getNo());
		if(dept == null||deptNo!=dept.getNo()) {
			dept=getDeptService().getDeptByNo(deptNo);
			req.getSession().setAttribute("dept", dept);
		}
		req.getRequestDispatcher("emp.jsp").forward(req, resp);
	}
}
