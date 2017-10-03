package com.qfedu.persistence;

import com.qfedu.domain.User;
/**
 * �û��������ݶ���
 * @author jinyu
 *
 */
public interface UserDao {
	
	/**
	 * �����û��������û�	
	 * @param username�û���
	 * @return �û�������� null
	 */
	User finByUsername(String name);
	
	/**
	 * �����û�
	 * @param user �û�����
	 * @return ����ɹ�����true ���߷���false
	 */
	boolean save(User user);
	
	/**
	 * ��ȡ�û�
	 * @param user �û�����
	 * @return ����ɹ�����true ���߷���false
	 */

}
