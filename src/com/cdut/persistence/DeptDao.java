package com.qfedu.persistence;

import java.util.List;

import com.qfedu.domain.Dept;

public interface DeptDao {
	/**
	 * ����
	 * @param dept ����
	 * @return ����ɹ�����true ���߷���false
	 */
	boolean save(Dept dept);
	/**
	 * ���ݱ��ɾ��
	 * @param no ���
	 * @return ɾ���ɹ�����true ���߷���false
	 */
	boolean deleteByNo(Integer no);
	/**
	 * ���²���
	 * @param dept ����
	 * @return ɾ���ɹ�����true ���߷���false
	 */
	boolean update(Dept dept);
	/**
	 * ���� ����
	 * @return ���ż�
	 */
	List<Dept> finallAll();
	/**
	 * ��ѯ��������
	 * @param no ���ű��
	 * @return ��������
	 */
	int countEmpByNo(Integer no);
	
	/**
	 * ��ѯ����
	 * @param no ���ű��
	 * @return ����
	 */
	Dept findById(Integer no);
}
