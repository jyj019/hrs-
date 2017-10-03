package com.qfedu.domain;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/**
 * ������
 * @author jinyu
 *
 */
public class Dept implements Serializable{
	//Integer �� int ����,Integer�����жϿ�
	private Integer no;		//���
	private String name;	//����
	private String location;//���ڵ�
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public String getNameUrl() {
		try {
			return URLEncoder.encode(name,"utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
			
		}
		
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Dept [no=" + no + ", name=" + name + ", location=" + location + "]";
	}

	
}
