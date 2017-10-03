package com.qfedu.domain;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/**
 * 部门类
 * @author jinyu
 *
 */
public class Dept implements Serializable{
	//Integer 比 int 好用,Integer可以判断空
	private Integer no;		//编号
	private String name;	//名称
	private String location;//所在地
	
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
