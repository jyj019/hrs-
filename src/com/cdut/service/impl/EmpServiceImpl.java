package com.qfedu.service.impl;


import com.qfedu.domain.Emp;
import com.qfedu.persistence.EmpDao;
import com.qfedu.persistence.impl.EmpDaoImpl;
import com.qfedu.service.EmpService;
import com.qfedu.util.PageBean;
/**
 * 创建业务对象的工厂方法
 * @author jinyu
 *
 */
public class EmpServiceImpl implements EmpService {
	
	private EmpDao empDao=new EmpDaoImpl();
	@Override
	public boolean addNewEmp(Emp emp) {
		return empDao.save(emp);
	}
	
	@Override
	public PageBean<Emp> listAllEmpsByDeptNo(Integer no, int page, int size) {
		return empDao.findEmpsByDeptNo(no,page,size);
	}
	
	@Override
	public boolean removeEmpByNo(Integer no) {
		return empDao.deleteByNo(no);
	}

	@Override
	public boolean updataEmpByNo(Emp emp) {
		return empDao.update(emp);
	}

	@Override
	public Emp findEmpByEmpNo(Integer no) {
		return empDao.findEmpByEmpNo(no);
	}

}
