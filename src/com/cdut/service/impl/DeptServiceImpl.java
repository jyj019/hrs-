package com.qfedu.service.impl;

import java.util.Iterator;
import java.util.List;

import com.qfedu.domain.Dept;
import com.qfedu.persistence.DeptDao;
import com.qfedu.persistence.impl.DeptDaoImpl;
import com.qfedu.service.DeptService;

public class DeptServiceImpl implements DeptService {
	private DeptDao deptDao=new DeptDaoImpl();
	
	@Override
	public List<Dept> listAllDepts(){
		List<Dept> deptList=deptDao.finallAll();
		return deptList;
	}		

	@Override
	public boolean removeDeptByNo(Integer no) {
		if(deptDao.countEmpByNo(no)==0) {
			return deptDao.deleteByNo(no);
		}else {
			return false;
		}
	}

	@Override
	public boolean addNewDept(Dept dept) {
		//+判断有无部门编号
		List<Dept> deptList=deptDao.finallAll();
		Iterator<Dept> deptListIterator=deptList.iterator();
		while(deptListIterator.hasNext()) {
			if(deptListIterator.next().getNo().equals(dept.getNo())) {
				return false;
			}
		}
		return deptDao.save(dept);
	}

	@Override
	public boolean updataDeptByNo(Dept dept) {
		List<Dept> deptList=deptDao.finallAll();
		Iterator<Dept> deptListIterator=deptList.iterator();
		while(deptListIterator.hasNext()) {
			if(deptListIterator.next().getNo().equals(dept.getNo())) {
				return deptDao.update(dept);
			}
		}
		return false;
	}

	@Override
	public Dept getDeptByNo(Integer no) {
		return deptDao.findById(no);
	}
	
	
}
