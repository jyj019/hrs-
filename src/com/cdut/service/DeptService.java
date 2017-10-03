package com.qfedu.service;

import java.util.List;

import com.qfedu.domain.Dept;

/**
 * �������ҵ��ӿ�
 * @author jinyu
 *
 */
public interface DeptService {
	/**
	 * �г����в���
	 * @return ���沿�Ŷ�����б�����
	 */
	List<Dept> listAllDepts();
	/**
	 * ���ݲ��ű��ɾ������
	 * @param no ���ű��
	 * @return �Ƿ�ɹ�ɾ��
	 */
	boolean removeDeptByNo(Integer no);
	/**
	 * ����һ���²���
	 * @param dept ����
	 * @return �Ƿ�ɹ����
	 */
	boolean addNewDept(Dept dept);
	/**
	 * ���ݲ��ű�Ÿ��²���
	 * @param dept ����
	 * @return �Ƿ�ɹ�����
	 */
	boolean updataDeptByNo(Dept dept);
	/**
	 * ���ݲ��ű�Ż�ȡ����
	 * @param no ���ű��
	 * @return ����
	 */
	Dept getDeptByNo(Integer no);
}
