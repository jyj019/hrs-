package com.qfedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.Dept;
/**
 * 删除部门的控制类
 * @author jinyu
 *
 */
@WebServlet(urlPatterns="/delDept",loadOnStartup = 1)
public class DelDeptServlet extends BaseServlet {
	//private DeptService deptService = new DeptServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noString = req.getParameter("dno");
		if (noString != null) {
			int deptNo = Integer.parseInt(noString);
			
			boolean flag = getDeptService().removeDeptByNo(deptNo);
			if (flag) {
				// 如果删除部门成功则先刷新缓存数据
				Map<Integer,Dept>map=(Map<Integer,Dept>)
						req.getServletContext().getAttribute("cache");	
				map.remove(deptNo);
			}
			String responseText =flag?"success":"failed";
			PrintWriter pw=resp.getWriter();
			pw.write(responseText);
			pw.close();
		}
		
	}
	

}
