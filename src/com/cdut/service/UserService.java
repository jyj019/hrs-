package com.qfedu.service;

import com.qfedu.domain.User;
/**
 *�û����ҵ��ӿ� 
 * @author jinyu
 *
 */
public interface UserService {
	/**
	 * ��¼
	 * @param username �û���
	 * @param password ����
	 * @return ��½�ɹ�����true ���򷵻� false
	 */
	boolean login(String username,String password);
	/**
	 * ע��
	 * @param user �û�����
	 * @return ע��ɹ�����true ���򷵻�false
	 */
	boolean register(User user);
}
