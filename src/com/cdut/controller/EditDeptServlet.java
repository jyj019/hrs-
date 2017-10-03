package com.qfedu.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.Dept;

@WebServlet(urlPatterns="/editDept",loadOnStartup=1)
public class EditDeptServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer deptNo=Integer.parseInt(req.getParameter("dno"));
		String nameString=req.getParameter("name");
		String locString=req.getParameter("location");
		if((deptNo!=null)&&(nameString!=null)&&(locString!=null)) {	
			Dept dept=new Dept();
			dept.setNo(deptNo);
			dept.setName(nameString);
			dept.setLocation(locString);
			//判断是否与数据库已有数据相同
			if(getDeptService().updataDeptByNo(dept)) {
				Map<Integer,Dept>map=(Map<Integer,Dept>)
						req.getServletContext().getAttribute("cache");	
				map.put(deptNo, dept);
				resp.sendRedirect("dept");
			}else {
				req.setAttribute("hint", "修改失败!");
				req.getRequestDispatcher("alter_dept.jsp").forward(req, resp);
			}
		}else {
			req.setAttribute("hint", "修改失败!");
			req.getRequestDispatcher("alter_dept.jsp").forward(req, resp);
		}
	}

}
