package com.als.web.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RowDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;

	//子元素列表
	List<FldDTO> flds=new ArrayList<FldDTO>();
	
	public void addFld(FldDTO fld){
		this.getFlds().add(fld);
	}
	public List<FldDTO> getFlds() {
		return flds;
	}
	public void setFlds(List<FldDTO> flds) {
		this.flds = flds;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String clos;

	public String getClos() {
		return clos;
	}

	public void setClos(String clos) {
		this.clos = clos;
	}

}
