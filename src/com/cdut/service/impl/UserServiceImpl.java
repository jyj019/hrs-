package com.qfedu.service.impl;

import org.apache.commons.codec.digest.DigestUtils;

import com.qfedu.domain.User;
import com.qfedu.persistence.UserDao;
import com.qfedu.persistence.impl.UserDaoImpl;
import com.qfedu.service.UserService;

/**
 * 用户相关业务实现
 * @author jinyu
 *
 */
public class UserServiceImpl implements UserService {
	//前面接口 后面是实现类    蛋 X=new 鸡(); public void foo(蛋 X){...}  public 蛋 bar(){....}
	//依赖倒转原则 -面向接口编程  	申明对象引用类型 方法返回类型 方法抽象类型
	//foo- fuck up  bar-beyond all recognization
	private UserDao userDao=new UserDaoImpl();
	
	@Override
	public boolean login(String username, String password) {
		User temp=userDao.finByUsername(username);
		if(temp!=null) {
			String md5=DigestUtils.md5Hex(password);
			//System.out.println(md5);
			return temp.getPassword().equals(md5);
		}
		return false;
	}

	@Override
	public boolean register(User user) {
		User temp=userDao.finByUsername(user.getUsername());
		//判断是否存在用户
		if(temp==null) {
			String md5=DigestUtils.md5Hex(user.getPassword());
			user.setPassword(md5);
			return userDao.save(user);
		}
		return false;
	}

}
