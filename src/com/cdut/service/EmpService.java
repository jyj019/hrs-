package com.qfedu.service;

import com.qfedu.domain.Emp;
import com.qfedu.util.PageBean;
/**
 * Ա�����ҵ��ӿ�
 * @author Administrator
 *
 */
public interface EmpService {
	/**
	 * ���ݲ��ű���г���������Ա��
	 * @param no ���
	 * @return ����Ա��
	 */
	//get �� list ��ͷ��
	PageBean<Emp> listAllEmpsByDeptNo(Integer no,int page,int size);
	/**
	 * ����Ա�����ɾ��Ա��
	 * @param no Ա�����
	 * @return �Ƿ�ɹ�ɾ��
	 */
	boolean removeEmpByNo(Integer no);
	/**
	 * ����һ����Ա��
	 * @param emp Ա��
	 * @return �Ƿ����ӳɹ�
	 */
	boolean addNewEmp(Emp emp);
	/**
	 * ����Ա����Ÿ���Ա��
	 * @param emp Ա��
	 * @return �Ƿ�ɹ�����
	 */
	boolean updataEmpByNo(Emp emp);
	/**
	 * ���ݲ��ű���г���������Ա��
	 * @param no ���
	 * @return ����Ա��
	 */
	//get �� list ��ͷ��
	Emp findEmpByEmpNo(Integer no);
	
}
