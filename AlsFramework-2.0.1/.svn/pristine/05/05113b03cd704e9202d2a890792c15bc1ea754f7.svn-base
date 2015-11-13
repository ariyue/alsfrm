package com.als.ums.module.ums.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.ex.AppException;
import com.als.frm.ex.DBAccessException;
import com.als.mod.domain.UmsEntity;
import com.als.ums.module.ums.dao.UmsEntityDAO;

@Repository("umsEntityDAOImpl")
public class UmsEntityDAOImpl extends BasDAOFacade<UmsEntity> implements UmsEntityDAO {

	private static final String SQL_QUERY_MAX_SID = "select Max(t.entity_sid) maxSid  from ums_entity  t";
	@Override
	public String getNextEntitySid(){
		
		//String nextSid = "00000";
		List<Map<String, Object>> list  = this.select(SQL_QUERY_MAX_SID, new HashMap());
		if (list != null && list.size() > 0 && list.get(0).get("maxSid") != null){
			String currentMaxSid =  list.get(0).get("maxSid").toString();
			char c1 = currentMaxSid.charAt(currentMaxSid.length() - 1);//个
			char c2 = currentMaxSid.charAt(currentMaxSid.length() - 2);//十
			char c3 = currentMaxSid.charAt(currentMaxSid.length() - 3);//百
			char c4 = currentMaxSid.charAt(currentMaxSid.length() - 4);//千
			char c5 = currentMaxSid.charAt(currentMaxSid.length() - 5);//万
			int i1 = parseInt(String.valueOf(c1));
			int i2 = parseInt(String.valueOf(c2));
			int i3 = parseInt(String.valueOf(c3));
			int i4 = parseInt(String.valueOf(c4));
			int i5 = parseInt(String.valueOf(c5));

			i1 += 1;
			if (i1 > 35) {
				i2 += 1;
				i1 -= 35;
			}
			
			if (i2 > 35){
				i2 -= 35;
				i3 +=1;
			}
			if (i3 >35){
				i3 -= 35;
				i4 +=1;
			}
			
			if (i4 >35){
				i4 -= 35;
				i5 +=1;
			}

			if (i5 > 35) {
				throw new AppException("超过了组织机构最大的范围！");
			}
			
			String d1 = parseString(i1);
			String d2 = parseString(i2);
			String d3 = parseString(i3);
			String d4 = parseString(i4);
			String d5 = parseString(i5);

			return  d5 + d4 + d3 + d2 + d1;
		} else {
			return "00001";
		}
	}
	
	
	private static int parseInt(String code) {

		if (code.equals("0")) {
			return 0;
		} else if (code.equals("1")) {
			return 1;
		} else if (code.equals("2")) {
			return 2;
		} else if (code.equals("3")) {
			return 3;
		} else if (code.equals("4")) {
			return 4;
		} else if (code.equals("5")) {
			return 5;
		} else if (code.equals("6")) {
			return 6;
		} else if (code.equals("7")) {
			return 7;
		} else if (code.equals("8")) {
			return 8;
		} else if (code.equals("9")) {
			return 9;
		}

		else if (code.equals("A")) {
			return 10;
		} else if (code.equals("B")) {
			return 11;
		} else if (code.equals("C")) {
			return 12;
		} else if (code.equals("D")) {
			return 13;
		} else if (code.equals("E")) {
			return 14;
		} else if (code.equals("F")) {
			return 15;
		} else if (code.equals("G")) {
			return 16;
		} else if (code.equals("H")) {
			return 17;
		} else if (code.equals("I")) {
			return 18;
		}

		else if (code.equals("J")) {
			return 19;
		} else if (code.equals("K")) {
			return 20;
		} else if (code.equals("L")) {
			return 21;
		} else if (code.equals("M")) {
			return 22;
		} else if (code.equals("N")) {
			return 23;
		} else if (code.equals("O")) {
			return 24;
		} else if (code.equals("P")) {
			return 25;
		} else if (code.equals("Q")) {
			return 26;
		} else if (code.equals("R")) {
			return 27;
		}

		else if (code.equals("S")) {
			return 28;
		} else if (code.equals("T")) {
			return 29;
		} else if (code.equals("U")) {
			return 30;
		} else if (code.equals("V")) {
			return 31;
		} else if (code.equals("W")) {
			return 32;
		} else if (code.equals("X")) {
			return 33;
		} else if (code.equals("Y")) {
			return 34;
		} else if (code.equals("Z")) {
			return 35;
		}

		else {
			throw new DBAccessException("转化出错");
		}
	}

	private static String parseString(int code) {

		if (code == 0) {
			return "0";
		} else if (code == 1) {
			return "1";
		} else if (code == 2) {
			return "2";
		} else if (code == 3) {
			return "3";
		} else if (code == 4) {
			return "4";
		} else if (code == 5) {
			return "5";
		} else if (code == 6) {
			return "6";
		} else if (code == 7) {
			return "7";
		} else if (code == 8) {
			return "8";
		} else if (code == 9) {
			return "9";
		}

		else if (code == 10) {
			return "a";
		} else if (code == 11) {
			return "b";
		} else if (code == 12) {
			return "c";
		} else if (code == 13) {
			return "d";
		} else if (code == 14) {
			return "e";
		} else if (code == 15) {
			return "f";
		} else if (code == 16) {
			return "g";
		} else if (code == 17) {
			return "h";
		} else if (code == 18) {
			return "i";
		}

		else if (code == 19) {
			return "j";
		} else if (code == 20) {
			return "k";
		} else if (code == 21) {
			return "l";
		} else if (code == 22) {
			return "m";
		} else if (code == 23) {
			return "n";
		} else if (code == 24) {
			return "o";
		} else if (code == 25) {
			return "p";
		} else if (code == 26) {
			return "q";
		} else if (code == 27) {
			return "r";
		}

		else if (code == 28) {
			return "s";
		} else if (code == 29) {
			return "t";
		} else if (code == 30) {
			return "u";
		} else if (code == 31) {
			return "v";
		} else if (code == 32) {
			return "w";
		} else if (code == 33) {
			return "x";
		} else if (code == 34) {
			return "y";
		} else if (code == 35) {
			return "z";
		}

		else {
			throw new AppException("转化出错");
		}
	}
	public static void main(String[] args) {
		
		String currentMaxSid = "12345";
		
		char c1 = currentMaxSid.charAt(currentMaxSid.length() - 1);//个
		char c2 = currentMaxSid.charAt(currentMaxSid.length() - 2);//十
		char c3 = currentMaxSid.charAt(currentMaxSid.length() - 3);//百
		char c4 = currentMaxSid.charAt(currentMaxSid.length() - 4);//千
		char c5 = currentMaxSid.charAt(currentMaxSid.length() - 5);//万
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
	}


	@Override
	public UmsEntity insertEntity(UmsEntity entity) {

		return this.insert(entity);
	}


	@Override
	public UmsEntity updateEntity(UmsEntity entity) {

		return this.update(entity);
	}


	@Override
	public List<UmsEntity> selectAll() {

		UmsEntity qryEntity = new UmsEntity();
		return this.select(qryEntity);
	}

}
