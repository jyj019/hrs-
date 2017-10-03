package com.qfedu.persistence;

//import java.util.List;

import com.qfedu.domain.Emp;
import com.qfedu.util.PageBean;


/**
 * 员工数据访问对象接口
 * @author Administrator
 *
 */
public interface EmpDao {
	/**
	 * 根据部门编号查找员工
	 * @param no 编号
	 * @param page 页码
	 * @param size 页面大小
	 * @return 分页器对象
	 */
	PageBean<Emp>findEmpsByDeptNo(Integer no,int page,int size);

	/**
	 * 保存员工
	 * @param emp 员工
	 * @return 保存成功
	 */
	boolean save(Emp emp);
	/**
	 * 删除员工
	 * @param no 编号
	 * @return 删除成功
	 */
	boolean deleteByNo(Integer no);
	/**
	 * 更新员工
	 * @param emp 员工
	 * @return 更新成功
	 */
	boolean update(Emp emp);
	/**
	 * 根据员工编号查找员工
	 * @param no 编号
	 * @return 查找的员工
	 */
	Emp findEmpByEmpNo(Integer no);
}
