package com.qfedu.service;

import java.util.List;

import com.qfedu.domain.Dept;

/**
 * 部门相关业务接口
 * @author jinyu
 *
 */
public interface DeptService {
	/**
	 * 列出所有部门
	 * @return 保存部门对象的列表容器
	 */
	List<Dept> listAllDepts();
	/**
	 * 根据部门编号删除部门
	 * @param no 部门编号
	 * @return 是否成功删除
	 */
	boolean removeDeptByNo(Integer no);
	/**
	 * 新增一个新部门
	 * @param dept 部门
	 * @return 是否成功添加
	 */
	boolean addNewDept(Dept dept);
	/**
	 * 根据部门编号更新部门
	 * @param dept 部门
	 * @return 是否成功更新
	 */
	boolean updataDeptByNo(Dept dept);
	/**
	 * 根据部门编号获取部门
	 * @param no 部门编号
	 * @return 部门
	 */
	Dept getDeptByNo(Integer no);
}
