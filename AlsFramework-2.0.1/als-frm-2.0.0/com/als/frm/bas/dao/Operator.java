package com.als.frm.bas.dao;


/**
 * SQL操作符
 * @author Vincent
 *
 */
public enum Operator  {

	/*E:equal
	N:not
	G:greater
	T:than 
	L:less*/
	eq(" = "), //等于
	gt(" > "), //大于
	lt(" < "), //小于
	ne(" <> "), //不等于
	ge(" >= "), //大于等于
	le(" <= "), //小于等于
	lk(" like ")
	
	;
	
	private String val;
	private Operator(String value){
		this.val = value;
	}
	
	public String getVal(){
		return this.val;
	}
	
	public static void main(String[] args) {
		Operator a = Operator.ge;
		System.out.println(a.getVal());
	}
}
