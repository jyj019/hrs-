package com.qfedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.qfedu.domain.Dept;
import com.qfedu.domain.Emp;
//import com.qfedu.dto.EmpDto;
import com.qfedu.util.PageBean;

@WebServlet(urlPatterns="/emp",loadOnStartup=1)
public class ShowEmpServlet extends BaseServlet {
	//�����û����� �����ݰ󶨵��̶��������� ��ת��ָ��ҳ����ʾ
	
	
	private static final int DEFAULT_SIZE = 5;
	private static final int DEFAULT_PAGE = 1;
		
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//?
		Dept dept=(Dept)req.getSession().getAttribute("dept");
		if (dept != null) {
			int page = DEFAULT_PAGE;
			String pageStr = req.getParameter("page");
			if (pageStr != null) {
				try {
					page = Integer.parseInt(pageStr);
					page = page <= 0 ? DEFAULT_PAGE : page;
				} catch (NumberFormatException e) {
				
				}
			}
			int size = DEFAULT_SIZE;
			PageBean<Emp> pageBean = getEmpService().listAllEmpsByDeptNo(dept.getNo(), page, size);
			//1������ת��ΪJSON��ʽ���ַ������ظ������
			
			//{'empList':[{'no':1122,'name':'luohao',...},{},...],'totalpage':4,'currentPage':2,'pageSize';5}
			//��Json�ַ�������������ͨ��MIME���͸��������������JSCON��ʽ  
			//Gson / Fastjson  
			String jsonStr=JSON.toJSONString(pageBean);
			//System.out.println(jsonStr);
			resp.setContentType("application/json;charest=utf-8");
			PrintWriter pw = resp.getWriter(); 
			pw.write(jsonStr); 
			pw.flush();
			
			
//			req.setAttribute("empList", pageBean.getDataModel());
//			req.setAttribute("totalPage", pageBean.getTotalPage());
//			req.setAttribute("currentPage", pageBean.getCurrentPage());
//			req.getRequestDispatcher("emp.jsp").forward(req, resp);
		}	
	}
}

