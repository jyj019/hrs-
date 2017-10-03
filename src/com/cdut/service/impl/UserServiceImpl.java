package com.qfedu.service.impl;

import org.apache.commons.codec.digest.DigestUtils;

import com.qfedu.domain.User;
import com.qfedu.persistence.UserDao;
import com.qfedu.persistence.impl.UserDaoImpl;
import com.qfedu.service.UserService;

/**
 * �û����ҵ��ʵ��
 * @author jinyu
 *
 */
public class UserServiceImpl implements UserService {
	//ǰ��ӿ� ������ʵ����    �� X=new ��(); public void foo(�� X){...}  public �� bar(){....}
	//������תԭ�� -����ӿڱ��  	���������������� ������������ ������������
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
		//�ж��Ƿ�����û�
		if(temp==null) {
			String md5=DigestUtils.md5Hex(user.getPassword());
			user.setPassword(md5);
			return userDao.save(user);
		}
		return false;
	}

}
