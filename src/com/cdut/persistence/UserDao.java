package com.qfedu.persistence;

import com.qfedu.domain.User;
/**
 * 用户访问数据对象
 * @author jinyu
 *
 */
public interface UserDao {
	
	/**
	 * 根据用户名查找用户	
	 * @param username用户名
	 * @return 用户对象或者 null
	 */
	User finByUsername(String name);
	
	/**
	 * 保存用户
	 * @param user 用户对象
	 * @return 保存成功返回true 否者返回false
	 */
	boolean save(User user);
	
	/**
	 * 读取用户
	 * @param user 用户对象
	 * @return 保存成功返回true 否者返回false
	 */

}
