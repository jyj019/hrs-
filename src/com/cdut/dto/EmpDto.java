package com.qfedu.dto;

import java.io.Serializable;
/**
 * Ա�����ݴ������ (Data Transfer Object / Value Object)
 * @author jinyu
 *
 */
//���ݴ������  (data transfer object/value object)
public class EmpDto implements Serializable{
	private Integer no;
	private String name;
	private String sex;
	private String status;
	private String job;
	private String tel;

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

	public String getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex?"��":"Ů";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
