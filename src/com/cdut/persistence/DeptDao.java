package com.qfedu.persistence;

import java.util.List;

import com.qfedu.domain.Dept;

public interface DeptDao {
	/**
	 * 保存
	 * @param dept 部门
	 * @return 保存成功返回true 否者返回false
	 */
	boolean save(Dept dept);
	/**
	 * 根据编号删除
	 * @param no 编号
	 * @return 删除成功返回true 否者返回false
	 */
	boolean deleteByNo(Integer no);
	/**
	 * 更新部门
	 * @param dept 部门
	 * @return 删除成功返回true 否者返回false
	 */
	boolean update(Dept dept);
	/**
	 * 遍历 部门
	 * @return 部门集
	 */
	List<Dept> finallAll();
	/**
	 * 查询部门人数
	 * @param no 部门编号
	 * @return 部门人数
	 */
	int countEmpByNo(Integer no);
	
	/**
	 * 查询部门
	 * @param no 部门编号
	 * @return 部门
	 */
	Dept findById(Integer no);
}
