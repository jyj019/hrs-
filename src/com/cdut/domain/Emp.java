package com.qfedu.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * Ա����
 * @author jinyu
 *
 */
public class Emp implements Serializable{
	private Integer no;		//���
	private String name;	//����
	private Boolean sex;	//�Ա�
	private String job;		//����
	private Emp mgr;		//����
	//sql decimal(ָ��С�����λ)
	private Double salary;	//����
	private Date hireDate;	//��ְ����
	private Boolean status;	//�Ƿ���ְ
	//��2�������� byte[]		
	private String photo;	//��Ƭ��·����
	private String tel;		//�绰����
	private Dept dept;		//���ڲ���
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean getSex(){
	 	return sex;
	}
	 
	
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Emp getMgr() {
		return mgr;
	}
	public void setMgr(Emp mgr) {
		this.mgr = mgr;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	public boolean getStatus(){
	 	return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
