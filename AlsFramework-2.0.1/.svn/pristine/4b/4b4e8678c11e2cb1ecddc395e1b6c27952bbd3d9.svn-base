package com.als.tol.module.tol.act;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.comm.dto.AppData;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;

@Action("autovoaction")
public class AutoVOAction extends BasAction implements IAction {

	@Autowired
	private BasDAOFacade basDAOFacade;

	@Override
	public String getTransCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object init(AppData appData) {
		// TODO Auto-generated method stub
		return null;
	}

	@ActionMetod("genralcode")
	public Object genralCode(AppData appData) {

		StringBuffer sb = new StringBuffer();
		StringBuffer i18n = new StringBuffer();
		String bo = appData.getValue("bo").toString(); //VO全称
		String pkg = appData.getValue("pkg").toString();//标签title包名
		
		
		sb.append("<vo class=\""+bo+"VO\">\n");
		try {
			Class clazz = Class.forName(bo);// 根据类名获得其对应的Class对象 写上你想要的类名就是了
											// 注意是全名 如果有包的话要加上
											// 比如java.Lang.String
			Field[] fields = clazz.getDeclaredFields();// 根据Class对象获得属性 私有的也可以获得
			for (Field f : fields) {
				sb.append("    <column field=\""+f.getName()+"\" title=\""+pkg + "." + f.getName()+"\" type=\""+f.getType().getName()+"\" sortable=\"true\" align=\"center\"/>\n");
				//System.out.println(f.getName());// 打印每个属性的类型名字
				//System.out.println(f.getType().getName());// 打印每个属性的类型名字
				i18n.append(pkg+"." + f.getName() + "=" + f.getName() + "\n");
			}
			sb.append("</vo>\n");
			//System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map result = new HashMap(2);
		result.put("vo", sb.toString());
		result.put("i18n", i18n.toString());
		return result;

	}

	public static void main(String[] args) {

		String bo = "com.als.mod.domain.UmsTransCode";
		StringBuffer sb = new StringBuffer();
		sb.append("<vo class=\""+bo+"VO\">\n");
		try {
			Class clazz = Class.forName(bo);// 根据类名获得其对应的Class对象 写上你想要的类名就是了
											// 注意是全名 如果有包的话要加上
											// 比如java.Lang.String
			Field[] fields = clazz.getDeclaredFields();// 根据Class对象获得属性 私有的也可以获得
			for (Field f : fields) {
				sb.append("    <column field=\""+f.getName()+"\" title=\""+f.getName()+"\" type=\""+f.getType().getName()+"\" sortable=\"true\" align=\"center\"/>\n");
				//System.out.println(f.getName());// 打印每个属性的类型名字
				//System.out.println(f.getType().getName());// 打印每个属性的类型名字
			}
			sb.append("</vo>\n");
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		<vo class="com.als.mod.domain.FrmBasConstantVO">
		<column field="id" title="编号" type="Max32Text" sortable="true" align="center"/>
		<column field="name" title="常量名" type="Max32Text" sortable="true" align="center"/>
		<column field="code" title="常量码" type="Max32Text" sortable="true" align="center"/>
		<column field="itemCode" title="列码" type="Max32Text" sortable="true" align="center"/>
		<column field="itemText" title="列名" type="Max32Text" sortable="true" align="center"/>
	</vo>
	*/

	}

}
