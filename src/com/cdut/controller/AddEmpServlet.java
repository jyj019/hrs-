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

@WebServlet(urlPatterns="/addEmp",loadOnStartup=1)
@MultipartConfig(maxFileSize=10*1024*1024)
public class AddEmpServlet extends BaseServlet{

	private static final int DEFAULT_IMAGE_HEIGHT = 150;
	private static final int DEFAULT_IMAGE_WIDTH = 200;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		
		Integer no=Integer.parseInt(req.getParameter("no"));
		String name=req.getParameter("name");		
		boolean sex=req.getParameter("sex").equals("1");
		String job=req.getParameter("job");
		double salary=Double.parseDouble(req.getParameter("salary"));
		Date hireDateStr=CommonUtil.stringToDate("yyyy-MM-dd",req.getParameter("hiredate"));
		//System.out.println(req.getParameter("hiredate"));
		String tel=req.getParameter("tel");
		Part part=req.getPart("photo");
		Emp emp=new Emp();
		emp.setNo(no);
		emp.setName(name);
		emp.setJob(job);
		emp.setSex(sex);
		emp.setSalary(salary);
		emp.setStatus(true);
		emp.setHireDate(hireDateStr);	
		emp.setTel(tel);
		
		Emp mgr = new Emp();
		emp.setMgr(mgr);
		if(part.getSize()>0) {
	//		InputStream inputStream=part.getInputStream();
	//		byte[] buffer=new byte[inputStream.available()];
	//		String originalName=CommonUtil.getUniqueFilename();
			//String newFilename=CommonUtil.getUniqueFilename()+
			//	CommonUtil.getFilenameSuffix(originalName);
			String newFilename = CommonUtil.getUniqueFilename() + ".png";
			String path=req.getServletContext().getRealPath("/images");
			File file=new File(path+"/"+newFilename);
			
			CommonUtil.compressImage(part.getInputStream(), file, 
					DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT);
			emp.setPhoto(newFilename);
			//oldImage.getWidth();
			//double rate=200.0/oldImage.getWidth();
			//int newHeight=(int)(oldImage.)			
			//type 1表示三原色构图   BufferedImage.Ty
		}
		
		int dno = Integer.parseInt(req.getParameter("dno"));
		Map<Integer, Dept> map = (Map<Integer, Dept>) req.getServletContext().getAttribute("cache");
		Dept dept=map.get(dno);
		emp.setDept(dept);	
		
		if(emp.getHireDate().equals(null)){
			req.setAttribute("hint", "增加失败!");
			req.getRequestDispatcher("add_emp.jsp").forward(req, resp);
		}else {
			if(getEmpService().addNewEmp(emp)) {
		//		req.setAttribute("deptNo", deptNo);
		//		req.setAttribute("deptName", deptName);
				req.setAttribute("dept",dept);
				resp.sendRedirect("toEmp?dno="+dno);
			}else {
				req.setAttribute("hint", "增加失败!");
				req.getRequestDispatcher("add_emp.jsp").forward(req, resp);
			}
		}

		//part.getSubmittedFileName()获取文件原名	方法：时间戳：毫秒加日期     哈希算法 uuid 全局唯一标识符 
	}

}