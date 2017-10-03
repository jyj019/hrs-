package com.qfedu.persistence;

//import java.util.List;

import com.qfedu.domain.Emp;
import com.qfedu.util.PageBean;


/**
 * Ա�����ݷ��ʶ���ӿ�
 * @author Administrator
 *
 */
public interface EmpDao {
	/**
	 * ���ݲ��ű�Ų���Ա��
	 * @param no ���
	 * @param page ҳ��
	 * @param size ҳ���С
	 * @return ��ҳ������
	 */
	PageBean<Emp>findEmpsByDeptNo(Integer no,int page,int size);

	/**
	 * ����Ա��
	 * @param emp Ա��
	 * @return ����ɹ�
	 */
	boolean save(Emp emp);
	/**
	 * ɾ��Ա��
	 * @param no ���
	 * @return ɾ���ɹ�
	 */
	boolean deleteByNo(Integer no);
	/**
	 * ����Ա��
	 * @param emp Ա��
	 * @return ���³ɹ�
	 */
	boolean update(Emp emp);
	/**
	 * ����Ա����Ų���Ա��
	 * @param no ���
	 * @return ���ҵ�Ա��
	 */
	Emp findEmpByEmpNo(Integer no);
}
