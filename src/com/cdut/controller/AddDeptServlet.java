package com.qfedu.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.Dept;

@WebServlet(urlPatterns="/addDept",loadOnStartup=1)
public class AddDeptServlet extends BaseServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noString=req.getParameter("dno");
		Integer deptNo=Integer.parseInt(noString);
		String nameString=req.getParameter("name");
		String locString=req.getParameter("location");
		if((deptNo!=null)&&(nameString!=null)&&(locString!=null)) {	
			Dept dept=new Dept();
			dept.setNo(deptNo);
			dept.setName(nameString);
			dept.setLocation(locString);
			//判断是否与数据库已有数据相同
			if(getDeptService().addNewDept(dept)) {
			//
				Map<Integer,Dept> map=(Map<Integer,Dept>)
						req.getServletContext().getAttribute("cache");
				map.put(deptNo, dept);
				resp.sendRedirect("dept");
			}else {
				req.setAttribute("hint", "增加失败!");
				req.getRequestDispatcher("add_dept.jsp").forward(req, resp);
			}
		}else {
			req.setAttribute("hint", "增加失败!");
			req.getRequestDispatcher("add_dept.jsp").forward(req, resp);
		}
	}

}
