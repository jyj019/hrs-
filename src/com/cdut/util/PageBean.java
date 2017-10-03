package com.qfedu.util;

import java.util.List;
/**
 * ��ҳ��
 * @author jinyu
 *
 * @param <T> ����
 */
public class PageBean<T> {
	private List<T> dataModel;
	private int totalPage;
	private int currentPage;
	private int pageSize;
	
	public PageBean(List<T> dataModel, int totalPage, int currentPage, int pageSize) {
		this.dataModel = dataModel;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	
	public List<T> getDataModel() {
		return dataModel;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
}
