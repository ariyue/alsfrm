package com.als.frm.bas.ddl;

/**
 * web请求返回类型
 * @author Vincent
 *
 */
public enum RstType {

	comm(0),msgWin(1),redirect(2),tab(3);
	int value;
	private RstType(int i ){
		this.value = i;
	}
	public static void main(String[] args) {
		System.out.println(RstType.comm.value);
	}
}
