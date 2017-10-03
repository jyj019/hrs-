package com.qfedu.controller;

import javax.servlet.http.HttpServlet;

import com.qfedu.service.DeptService;
import com.qfedu.service.EmpService;
import com.qfedu.service.UserService;
import com.qfedu.service.impl.ServiceFactory;
/**
 * �����Զ���Servlet�ĸ���
 * @author jinyu
 *
 */
public abstract class BaseServlet extends HttpServlet{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��ȡ�û�ҵ�����
	 * @return
	 */
	protected UserService getUserService() {
		return ServiceFactory.create(UserService.class);
	}
	
	/**
	 * ��ȡ����ҵ�����
	 * @return
	 */
	protected DeptService getDeptService() {
		return ServiceFactory.create(DeptService.class);	
	}
	/**
	 * ��ȡԱ��ҵ�����
	 * @return
	 */
	protected EmpService getEmpService() {
		return ServiceFactory.create(EmpService.class);	
	}
}
