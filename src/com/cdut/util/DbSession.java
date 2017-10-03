package com.qfedu.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���ݿ�Ự
 * @author jinyu
 *
 */
public class DbSession {
	private Connection connection;
	/**
	 * �������ݿ�Ự
	 */
	public void open() {
		if(connection==null) {
			connection=DbResourceManager.openConnection();
		}
	}
	/**
	 * �ر����ݿ�Ự
	 */
	public void close() {
		DbResourceManager.closeConnection(connection);
	}
	/**
	 * ��������
	 */
	public void beginTx() {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.TX_EX, e);
		}
	}
	/**
	 * �ύ����
	 */
	public void commitTx() {
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.TX_EX, e);
		}
	}
	/**
	 * �ع�����
	 */
	public void rollbackTx() {
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.TX_EX, e);
		}
	}
	
	/**
	 * ִ����ɾ��
	 * @param con ���Ӷ���
	 * @param sql Sql���
	 * @param params �滻SQl�����ռλ���Ĳ���
	 * @return ��Ӱ�������
	 */
	public int executeUpdate(String sql,Object...params) {		
		try(java.sql.PreparedStatement stmt=connection.prepareStatement(sql)){	
			for(int i=0;i<params.length;++i) {
				stmt.setObject(i+1, params[i]);
			}
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.EXEC_EX, e);
		}		
	}
	
	/**
	 * ִ�в�ѯ
	 * @param con ���Ӷ���
	 * @param sql Sql���
	 * @param params �滻SQl�����ռλ���Ĳ���
	 * @return ���������
	 */
	public ResultSet executeQuery(String sql,Object...params) {		
		try {
			java.sql.PreparedStatement stmt=connection.prepareStatement(sql);
			for(int i=0;i<params.length;++i) {
				stmt.setObject(i+1, params[i]);
			}return stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.EXEC_EX, e);
		}
	}
}
