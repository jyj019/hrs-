package com.qfedu.util;
/**
 * �������ݿ�Ự�Ĺ���
 * @author jinyu
 *
 */
public class DbSessionFactory {
	
	private static ThreadLocal<DbSession> threadLocal =new ThreadLocal<>();
	
	private DbSessionFactory() {
		throw new AssertionError();
	}
	/**
	 * ��ø���ǰ�̰߳󶨵����ݿ�Ự����
	 * @return 
	 */
	public static DbSession getCurrentDbSession(){
		DbSession session=threadLocal.get();
		if(session==null) {
			session =new DbSession();
			threadLocal.set(session);
		}
		session.open();
		return session;
	}
	
	/**
	 * �رպϵ�ǰ�̰߳󶨵����ݿ�Ự
	 */
	public static void closeCurrentDbSession() {
		DbSession session=threadLocal.get();
		if(session!=null) {
			threadLocal.remove();
			session.close();
		}
	}
	
}
