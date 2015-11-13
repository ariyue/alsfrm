package com.als.web.action.demo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.als.frm.comm.dto.AppData;
import com.als.frm.ex.AppException;
import com.als.mod.domain.UmsUser;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;

@Action("user")
public class UserAction extends BasAction implements IAction{

	@ActionMetod("commadTest")
	public Object testJson(AppData appData){
		
		
		String st = appData.getValue("staDateTime").toString();// request.getParameter("staDateTime");
		String et = appData.getValue("endDateTime").toString();//request.getParameter("endDateTime");
		System.out.println("st=" + st);
		System.out.println("et=" + et);
		JSONArray dataList = JSONArray.fromObject(appData.getValue("siteList"));
		for (int i = 0, len = dataList.size(); i < len; i++){
			JSONObject record = dataList.getJSONObject(i);
			System.out.println("txt=" + record.getString("txt") + ";val=" + record.getString("val"));
		}
		System.out.println("执行完成!");
		List userList = new ArrayList();
		for (int i = 0; i <9; i ++){
			UmsUser u = new UmsUser();
			u.setId("COCO_" + String.valueOf(i));
			u.setUserName("可可" + String.valueOf(i));
			userList.add(u);
		}
		Map result = new HashMap();
		result.put("resutCode", "123456");
		result.put("resutMsg", "执行完成");
		result.put("resutDataList", userList);
	
		try {
			int i = 1/0;
		} catch (Exception e) {
			throw new AppException("2222");
		}
		
		
		return result;
	}

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
	
	
}
