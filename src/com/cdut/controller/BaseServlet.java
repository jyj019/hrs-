package com.qfedu.controller;

import javax.servlet.http.HttpServlet;

import com.qfedu.service.DeptService;
import com.qfedu.service.EmpService;
import com.qfedu.service.UserService;
import com.qfedu.service.impl.ServiceFactory;
/**
 * 所有自定义Servlet的父类
 * @author jinyu
 *
 */
public abstract class BaseServlet extends HttpServlet{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 获取用户业务对象
	 * @return
	 */
	protected UserService getUserService() {
		return ServiceFactory.create(UserService.class);
	}
	
	/**
	 * 获取部门业务对象
	 * @return
	 */
	protected DeptService getDeptService() {
		return ServiceFactory.create(DeptService.class);	
	}
	/**
	 * 获取员工业务对象
	 * @return
	 */
	protected EmpService getEmpService() {
		return ServiceFactory.create(EmpService.class);	
	}
}
