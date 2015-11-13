package com.als.frm.comm.dto;

import java.util.List;

/**
 * //分页条
var pagination = {
	totalRecord:72, // 总记录数
   	totalPage:8, // 总页数
   	pageSize:23, // 每页记录数
   	pageNo:5, //当前页码，第一页的no为1
   	lastPageSize:2 //最后一页的记录数
};

 * @author Administrator
 *
 */
public class Pagination<T> implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 默认每页大小
	 */
	private final static int DEFAULT_PAGE_SIZE = 3;

	/**
	 * 查询数据集
	 */
	private List<T> dataList;

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	/**
	 * 当前页,第1页的页码为1
	 */
	private int pageNo;
	
	/**
	 * 总页数
	 */
	private int totalPage;
	
	/**
	 * 每页大小
	 */
	private int pageSize = DEFAULT_PAGE_SIZE;
	
	/**
	 * 总记录数
	 */
	//private int totalRecord;
	
	private int total;
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * 最后一页的实际的记录数
	 */
	private int lastPageSize;
	
	/**
	 * 排序字段名
	 */
	String orderField;
	
	/**
	 * 排序类别(asc/desc)
	 */
	String orderType;



	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/*public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}*/

	public int getLastPageSize() {
		return lastPageSize;
	}

	public void setLastPageSize(int lastPageSize) {
		this.lastPageSize = lastPageSize;
	}

	
	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
}
