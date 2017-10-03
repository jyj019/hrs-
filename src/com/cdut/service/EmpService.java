package com.qfedu.service;

import com.qfedu.domain.Emp;
import com.qfedu.util.PageBean;
/**
 * 员工相关业务接口
 * @author Administrator
 *
 */
public interface EmpService {
	/**
	 * 根据部门编号列出部门所有员工
	 * @param no 编号
	 * @return 所有员工
	 */
	//get 和 list 打头好
	PageBean<Emp> listAllEmpsByDeptNo(Integer no,int page,int size);
	/**
	 * 根据员工编号删除员工
	 * @param no 员工编号
	 * @return 是否成功删除
	 */
	boolean removeEmpByNo(Integer no);
	/**
	 * 新增一个新员工
	 * @param emp 员工
	 * @return 是否增加成功
	 */
	boolean addNewEmp(Emp emp);
	/**
	 * 根据员工编号更新员工
	 * @param emp 员工
	 * @return 是否成功更新
	 */
	boolean updataEmpByNo(Emp emp);
	/**
	 * 根据部门编号列出部门所有员工
	 * @param no 编号
	 * @return 所有员工
	 */
	//get 和 list 打头好
	Emp findEmpByEmpNo(Integer no);
	
}
