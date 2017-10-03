package com.qfedu.persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.qfedu.domain.Dept;
import com.qfedu.domain.Emp;
import com.qfedu.persistence.EmpDao;
import com.qfedu.util.DbException;
import com.qfedu.util.DbSessionFactory;
import com.qfedu.util.PageBean;


public class EmpDaoImpl implements EmpDao {
	
	private static final String SELECT_EMP_BY_DEPT_SQL=
			//第几条开始 查几条上来
			"select eno, ename, esex, ejob, estatus, etel from tb_emp where dno=? limit ?,?";
	private static final String SELECT_EMP_BY_EMPNO_SQL=
			"select ename,esex,ejob,emgr,esal,ehiredate,estatus,ephoto,etel,dno "
			+ "from tb_emp where eno=?";
	private static final String SELECT_EMP_COUNT_SQL=
			"select count(eno) from tb_emp where dno=?";
	private static final String INSERT_EMP_SQL=
			"insert into tb_emp values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String DELETE_EMP_SQL=
			"delete from tb_emp where eno= ?";
	private static final String UPDATE_EMP_SQL = 
			"update tb_emp set ename=?,esex=?,ejob=?,emgr=?,esal=?,ehiredate=?,estatus=?,"
			+ "ephoto=?,etel=?,dno=? where eno=?";
	
	//private
	@Override
	public PageBean<Emp> findEmpsByDeptNo(Integer no,int page,int size) {
		ResultSet rs=DbSessionFactory.getCurrentDbSession().executeQuery(SELECT_EMP_BY_DEPT_SQL,
				no,(page-1)*size,size);
		ResultSet rs2=DbSessionFactory.getCurrentDbSession().executeQuery(SELECT_EMP_COUNT_SQL,no);
		List<Emp> empList=new ArrayList<>();
		try {
			while(rs.next()) {
				Emp emp=new Emp();
				emp.setNo(rs.getInt("eno"));
				emp.setName(rs.getString("ename"));
				emp.setSex(rs.getBoolean("esex"));
				emp.setJob(rs.getString("ejob"));
				emp.setStatus(rs.getBoolean("estatus"));
				emp.setTel(rs.getString("etel"));
				
				//System.out.println(rs.getBoolean("estatus")+"debug");
				
				empList.add(emp);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
			throw new DbException(DbException.RS_EX, e);
		}
		int total=0;
		try {
			total=rs2.next()?rs2.getInt(1):0;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.RS_EX, e);
		}
		int totalPage=(total-1)/size+1;
		empList=empList.size()>0?empList:Collections.emptyList();
		return new PageBean<>(empList,totalPage,page,size);		
	}
	
	@Override
	public Emp findEmpByEmpNo(Integer no) {
		ResultSet rs=DbSessionFactory.getCurrentDbSession().executeQuery(SELECT_EMP_BY_EMPNO_SQL,no);
		Emp emp=new Emp();
		try {
			if(rs.next()) {
				//"select ename,esex,ejob,esal,ehiredate,estatus,ephoto,etel,dno "+ "from tb_emp where eno=?";			
				emp.setNo(no);
				emp.setName(rs.getString("ename"));
				emp.setSex(rs.getBoolean("esex"));
				emp.setJob(rs.getString("ejob"));
				emp.setSalary(rs.getDouble("esal"));
				//emp.setHireDate(rs.getDate(rs.getString("ehiredate")));
				emp.setStatus(rs.getBoolean("estatus"));
				emp.setPhoto(rs.getString("ephoto"));
				emp.setTel(rs.getString("etel"));
				Dept dept=new Dept();
				dept.setNo(rs.getInt("dno"));
				emp.setDept(dept);
			}
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(DbException.RS_EX, e);
		}
	}

	
	@Override
	public boolean save(Emp emp) {
			return DbSessionFactory.getCurrentDbSession().executeUpdate(INSERT_EMP_SQL, 
					emp.getNo(),emp.getName(),emp.getSex(),
					emp.getJob(),emp.getMgr().getNo(),emp.getSalary(), 
					emp.getHireDate(), emp.getStatus(), emp.getPhoto(), 
					emp.getTel(), emp.getDept().getNo()) == 1;
	}
			

	@Override
	public boolean deleteByNo(Integer no) {
		// "delete from tb_dept where dno= ?"
				//受影响的行数是否为1	
				return DbSessionFactory.getCurrentDbSession().executeUpdate(
						DELETE_EMP_SQL,no)==1;
	}
			

	@Override
	public boolean update(Emp emp) {
		// "update tb_dept set dept"
				//受影响的行数是否为1		
				return DbSessionFactory.getCurrentDbSession().executeUpdate(
						UPDATE_EMP_SQL, 
						emp.getName(),emp.getSex(),
						emp.getJob(),emp.getMgr().getNo(),emp.getSalary(),
						emp.getHireDate(),emp.getStatus(),emp.getPhoto(),
						emp.getTel(),emp.getDept().getNo(),emp.getNo())==1;
	}




	


}
