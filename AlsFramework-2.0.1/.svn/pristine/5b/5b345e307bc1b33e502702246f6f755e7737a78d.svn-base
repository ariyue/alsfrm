package com.als.ums.module.ums.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.ex.BizException;
import com.als.frm.ex.DBAccessException;
import com.als.mod.domain.UmsUnit;
import com.als.ums.module.ums.dao.UmsUnitDAO;

@Repository("umsUnitDAOImpl")
public class UmsUnitDAOImpl extends BasDAOFacade<UmsUnit>  implements UmsUnitDAO{

	private static final String SQL_P_RELATIONSHIP = "SELECT t.unit_relationship relationship FROM ums_unit t WHERE t.id= :id";
	
	private static final String SQL_MAX_RELATIONSHIP = "SELECT MAX(t.unit_relationship) relationship FROM ums_unit t WHERE t.pid= :id ";
	@Override
	public String getNewRelationship(String unitPid) {


		// Object[] params = { unitPid };
		String relationship = "00";
		String pRelationship = "00";
		Map param = new HashMap(1);
		param.put("id", unitPid);
		try {
			List<Map<String, Object>> list = this.select(SQL_P_RELATIONSHIP, param);
			pRelationship = list.get(0).get("relationship").toString();
			
			list = this.select(SQL_MAX_RELATIONSHIP, param);
			if (list != null && list.size() > 0 && list.get(0).get("relationship") != null) {
				relationship = list.get(0).get("relationship").toString();
			} else {
				return pRelationship + "01";
			}
		} catch (org.springframework.dao.DataAccessException e) {
			throw new DBAccessException("", new Object[]{});
		}

		char ch = relationship.charAt(relationship.length() - 2);
		char cl = relationship.charAt(relationship.length() - 1);

		int h = this.parseInt(String.valueOf(ch));
		int l = this.parseInt(String.valueOf(cl));

		l += 1;
		if (l > 35) {
			h += 1;
			l -= 35;
		}

		if (h > 35) {
			throw new BizException("err.ums.01003", new Object[]{});

		}

		String sh = this.parseString(h);
		String lh = this.parseString(l);

		return pRelationship + sh + lh;
	}
	
	private int parseInt(String code) {

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

		else if (code.equals("a")) {
			return 10;
		} else if (code.equals("b")) {
			return 11;
		} else if (code.equals("c")) {
			return 12;
		} else if (code.equals("d")) {
			return 13;
		} else if (code.equals("e")) {
			return 14;
		} else if (code.equals("f")) {
			return 15;
		} else if (code.equals("g")) {
			return 16;
		} else if (code.equals("h")) {
			return 17;
		} else if (code.equals("i")) {
			return 18;
		}

		else if (code.equals("j")) {
			return 19;
		} else if (code.equals("k")) {
			return 20;
		} else if (code.equals("l")) {
			return 21;
		} else if (code.equals("m")) {
			return 22;
		} else if (code.equals("n")) {
			return 23;
		} else if (code.equals("o")) {
			return 24;
		} else if (code.equals("p")) {
			return 25;
		} else if (code.equals("q")) {
			return 26;
		} else if (code.equals("r")) {
			return 27;
		}

		else if (code.equals("s")) {
			return 28;
		} else if (code.equals("t")) {
			return 29;
		} else if (code.equals("u")) {
			return 30;
		} else if (code.equals("v")) {
			return 31;
		} else if (code.equals("w")) {
			return 32;
		} else if (code.equals("x")) {
			return 33;
		} else if (code.equals("y")) {
			return 34;
		} else if (code.equals("z")) {
			return 35;
		}

		else {
			throw new DBAccessException("err.ums.01004!", new Object[]{});
		}
	}

	private String parseString(int code) {

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
			throw new DBAccessException("err.ums.01004!", new Object[]{});
		}
	}

}
