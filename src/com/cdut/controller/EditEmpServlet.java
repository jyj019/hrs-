package com.qfedu.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.qfedu.domain.Dept;
import com.qfedu.domain.Emp;
import com.qfedu.util.CommonUtil;

@WebServlet(urlPatterns="/editEmp",loadOnStartup=1)
@MultipartConfig(maxFileSize=10*1024*1024)
public class EditEmpServlet extends BaseServlet {
	
	private static final int DEFAULT_IMAGE_HEIGHT = 150;
	private static final int DEFAULT_IMAGE_WIDTH = 200;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String eno = req.getParameter("eno");
		Integer empNo=Integer.parseInt(eno);
		String name=req.getParameter("name");		
		boolean sex=req.getParameter("sex").equals("1");
		String job=req.getParameter("job");
		boolean status=req.getParameter("status").equals("1");
		double salary=Double.parseDouble(req.getParameter("salary"));
		Date hireDateStr=CommonUtil.stringToDate("yyyy-MM-dd",req.getParameter("hiredate"));
		System.out.println(req.getParameter("hiredate"));
		String tel=req.getParameter("tel");
		Part part=req.getPart("photo");
		Emp emp=new Emp();
		emp.setNo(empNo);
		emp.setName(name);
		emp.setSex(sex);
		emp.setJob(job);
		emp.setStatus(status);		
		emp.setSalary(salary);
		emp.setStatus(true);
		emp.setHireDate(hireDateStr);
		emp.setTel(tel);
		
		Emp mgr = new Emp();
		emp.setMgr(mgr);
		if(part.getSize()>0) {
			String newFilename = CommonUtil.getUniqueFilename() + ".png";
			String path=req.getServletContext().getRealPath("/images");
			File file=new File(path+"/"+newFilename);
			
			CommonUtil.compressImage(part.getInputStream(), file, 
					DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT);
			emp.setPhoto(newFilename);
		}
		
		int deptNo = Integer.parseInt(req.getParameter("dno"));
		Map<Integer, Dept> map = (Map<Integer, Dept>) req.getServletContext().getAttribute("cache");
		Dept dept=map.get(deptNo);
		emp.setDept(dept);		
		
		if(getEmpService().updataEmpByNo(emp)) {
			req.setAttribute("dept",dept);
			resp.sendRedirect("toEmp?dno="+deptNo);
		}else {
			req.setAttribute("hint", "Ôö¼ÓÊ§°Ü!");
			req.getRequestDispatcher("add_emp.jsp").forward(req, resp);
		}
	}
}
