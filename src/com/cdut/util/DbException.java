package com.qfedu.util;
/**
 * 数据库操作异常(运行时异常)
 * @author jinyu
 *
 */
public class DbException extends RuntimeException {
	
	public static final String RS_EX="解析结果时异常";
	public static final String EXEC_EX="执行SQL语句时异常";
	public static final String CONN_EX="无法建立数据库连接";
	public static final String DIS_EX="无法关闭SR数据库连接";
	public static final String TX_EX = "执行事务时异常";
	
	public DbException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
