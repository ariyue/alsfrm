package com.als.frm.module.frm.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.comm.dto.TreeDTO;
import com.als.frm.module.frm.biz.TreeBIZ;


@Service("treeBIZImpl")
public class TreeBIZImpl implements TreeBIZ {
	
	@Autowired
	private BasDAOFacade basDAOFacade;
	
	
	
	//@Override
	public void loadTree(String tableName,String pidFiledName, String pid, String orderFiledName, String idFieldName,
			String textFieldName, List<TreeDTO> resultList ) {
		
		String sql = "SELECT * FROM "+ tableName+" WHERE "+pidFiledName+"=:pid order by " + orderFiledName;
		Map<String, Object> args = new HashMap<String, Object>();
		//args.put("tableName", tableName);
		//args.put("pidFiledName", pidFiledName);
		args.put("pid", pid);
		//args.put("orderFiledName", orderFiledName);
		List<Map<String ,Object>> list = basDAOFacade.select(sql, args);
		if (resultList == null){
			resultList = new ArrayList<TreeDTO>();
		}
		for (int i = 0, len = list.size(); i < len; i ++){
			Map o = list.get(i);
			TreeDTO node = new TreeDTO();
			node.setId(o.get(idFieldName).toString());
			node.setText(o.get(textFieldName).toString());
			node.setAttributes(o);	
			List<TreeDTO> children = new ArrayList<TreeDTO>();
			loadTree(tableName, pidFiledName, o.get(idFieldName).toString(), orderFiledName, idFieldName, textFieldName, children);
			if (children != null && children.size() > 0){
				node.setChildren(children);
			}
			resultList.add(node);
			
		}
	}

}
