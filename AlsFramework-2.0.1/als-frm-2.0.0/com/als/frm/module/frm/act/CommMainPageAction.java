package com.als.frm.module.frm.act;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.xpath.XPath;

import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.util.FileUtil;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;

/**
 * mainpage共用方法
 * @author Administrator
 *
 */
@Action("commmainpageaction")
public class CommMainPageAction  extends BasAction implements IAction{

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
	
	
	@SuppressWarnings("unchecked")
	@ActionMetod("initallvos")
	public Object initAllVOS(AppData appData) {

		Map resultMap = new HashMap();
		try {
			Document doc = FileUtil.readXmlFile("/com/als/mod/vo/vos.xml");
			Element elRoot = (Element) XPath.selectSingleNode(doc.getRootElement(),"/mod");// 获取根元素
			List<Element> vos =  elRoot.getChildren("vo");
			for (int i =0, len = vos.size(); i < len; i ++){
				Element vo = vos.get(i);
				String className = vo.getAttributeValue("class");
				List<Element> cols =  vo.getChildren("column");
				List<Map> colsMap = new ArrayList<Map>();
				for (int j =0, len2 = cols.size(); j < len2; j ++){
					Element col = cols.get(j);
					Map m = new HashMap();
					m.put("field", col.getAttribute("field").getValue());
					m.put("type", col.getAttribute("type").getValue());
					String title = col.getAttribute("title").getValue();
					//grid表头的国际化，要通过此进行
					String title_i18n = this.generalI18nMsg(title, new Object[]{});
					m.put("title", title_i18n);
					//以下用于自动生成UI时使用
					m.put("title_code", title);
					Attribute sortable = col.getAttribute("sortable");
					if (sortable != null){
						m.put("sortable", sortable.getValue());
					}
					
					Attribute align = col.getAttribute("align");
					if (align != null){
						m.put("align", align.getValue());
					}
					
					Attribute checkbox = col.getAttribute("checkbox");
					if (checkbox != null){
						m.put("checkbox", checkbox.getValue());
					}
					
					Attribute hidden = col.getAttribute("hidden");
					if (hidden != null){
						m.put("hidden", hidden.getValue());
					}
					
					Attribute width = col.getAttribute("width");
					if (width != null){
						m.put("width", width.getValue());
					} else {
						m.put("width", "100");
					}
					
					
					colsMap.add(m);
				}
				resultMap.put(className, colsMap);
				
			/*	var field = $(this).attr("field");
				var title = $(this).attr("title");
				var type = $(this).attr("type");

				var sortable = $(this).attr("sortable");
				var align = $(this).attr("align");
				var checkbox = $(this).attr("checkbox");
				var hidden= $(this).attr("hidden");//隐藏列
				var width = $(this).attr("width") || 100;*/
				
			}
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}

}
