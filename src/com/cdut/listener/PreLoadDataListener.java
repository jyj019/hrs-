package com.qfedu.listener;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.qfedu.domain.Dept;
import com.qfedu.service.DeptService;
import com.qfedu.service.impl.ServiceFactory;

/*
 * <listener>
 * <listener-class>com.qfedu.listener.PreLoadDatalistener</listener-class>
 * </listener>
 */
@WebListener
public class PreLoadDataListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent evt) {
		DeptService deptService=ServiceFactory.create(DeptService.class);
		List<Dept> deptList=deptService.listAllDepts();
		//Collections.synchronizedMap(new HashMap<>());
		Map<Integer,Dept> cacheMap=new ConcurrentHashMap<>();
		for(Dept dept : deptList) {
			cacheMap.put(dept.getNo(),dept);
		}
		ServletContext servletContext=evt.getServletContext();
		servletContext.setAttribute("cache", cacheMap);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent evt) {
		
	}
	
}
