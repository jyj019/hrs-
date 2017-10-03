package com.qfedu.persistence.impl;

//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.mysql.jdbc.PreparedStatement;
import com.qfedu.domain.User;
import com.qfedu.persistence.UserDao;
import com.qfedu.util.DbException;
import com.qfedu.util.DbSessionFactory;
/**
 * �û����ݷ��ʵ�ʵ����
 * @author jinyu
 *
 */
public class UserDaoImpl implements UserDao {

	
	private static final String INSERT_USER_SQL = "insert into tb_user values(?,?,?)";
	private static final String SELECT_USER_SQL = "select password,email from tb_user where username=?";

	@Override
	//��״̬�Ķ������Ϊ���� ��������ϲ����״̬����(����Ҫ�ڴ汣��״̬)
	public User finByUsername(String username) {
		ResultSet rs=DbSessionFactory.getCurrentDbSession().executeQuery(
					SELECT_USER_SQL, username);
		try{
				User user=null;
			if(rs.next()) {
				user=new User();
				user.setUsername("username");
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				return user;
			}
			return null;
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.RS_EX, e);
		}
	}

	@Override
	public boolean save(User user) {
		return DbSessionFactory.getCurrentDbSession().executeUpdate
		(INSERT_USER_SQL,user.getUsername(),
				user.getPassword(),user.getEmail())==1;
	}

	public UserDaoImpl() {
		super();
		
	}

}
