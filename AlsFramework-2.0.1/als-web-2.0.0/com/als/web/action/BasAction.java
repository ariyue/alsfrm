package com.als.web.action;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.als.frm.bas.LookupProvider;
import com.als.frm.bas.dao.Operator;
import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.comm.util.MessageUtil;
import com.als.frm.comm.util.ReflectUtil;
import com.als.frm.ex.AppException;
import com.als.frm.module.frm.biz.BasBIZ;
import com.als.mod.bas.BasEntity;
import com.als.web.action.type.ActionMetod;
import com.als.web.action.type.SpringBean;

/**
 * action基础类
 * 
 * @author Vincent
 * 
 */
public class BasAction implements IBasAction {

	private ActionContext actionContext;

	public ActionContext getActionContext() {
		return actionContext;
	}

	public void setActionContext(ActionContext actionContext) {
		this.actionContext = actionContext;
	}
	
	//@SpringBean
	//private BasBIZ basBIZImpl;

	@Override
	public Object getBean(String beanName) {
		ServletContext application = this.getActionContext()
				.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(application);
		return context.getBean(beanName);
	}

	@Override
	public String generalI18nMsg(String key, Object[] params) {
		try {
			String msg = MessageUtil.getMessage(key, params, true);
			return msg;
		} catch (Exception e) {
			return key;
		}
	}
	@Override
	public void preHandle(AppData appData) {

		Field[] methods = this.getClass().getDeclaredFields();
		// 遍历方法对象
		for (Field field : methods) {
			// 判断方法对象上面有没有@ActionMetod注释
			if (field.isAnnotationPresent(SpringBean.class)) {

				field.setAccessible(true);// 关键。。。可访问私有变量。
				try {
					Object value = this.getBean(field.getName());
					field.set(this, value);
				} catch (Exception e) {
					//System.out.println(this.getClass().getName());
					//throw new AppException("找不到Spring上下文中的bean:" + field.getName());
					//err.als.03001
					//String message21 = messageSource.getMessage("err.als.03001", new Object[]{field.getName()}, Locale.ENGLISH);
					//System.out.println(e);
					//String errMsg = MessageUtil.getMessage("err.als.03001",  new Object[]{field.getName(), this.getClass().getName()});
					//LogHelper.writeInLog(e);
					throw new AppException("err.als.03001",  new Object[]{field.getName(), this.getClass().getName()});
				}
			}
		}

	}

	@ActionMetod("command")
	@Override
	public Object command(AppData appData) {
		// TODO Auto-generated method stub
		System.out.println("command -----------------------------------");
		return null;
	}

	@ActionMetod("query")
	@Override
	public Object query(AppData appData) {
		// TODO Auto-generated method stub
		System.out.println("query -----------------------------------");
		return null;
	}

	@Override
	public Object showMsg(String msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LookupProvider getLookupProvider() {
		
		return (LookupProvider) this.getBean("lookupProvider");
	}
	
	
	/**
	 * 采用mybatis的查询，仅对单表进行查询
	 * @param appData 前端传入的参数
	 * @param boName 传入的BO类名全称，如: com.als.mod.domain.UmsEntity
	 * 
	 */
	public Pagination lookupPage(AppData appData, String  boName){
		
		//根父节点ID
		String pid = "-1";
		
		//查询实体及条件
		Object qryEntity;
		try {
			Class onwClass = Class.forName(boName);
			qryEntity = onwClass.newInstance();
		} catch (Exception e) {
			throw new AppException("err.als.03003", new Object[]{boName});
		} 
		//UmsEntity qryEntity = new UmsEntity();
		//模精查询-----------------------------------------------
		Object searchboxVal = appData.getSearchboxVal();
		Object searchboxKey = appData.getSearchboxKey();
		//条件操作符
		Map<String,Operator> opMap = new HashMap();
		if (searchboxVal != null){
			ReflectUtil.setFieldValue(qryEntity, searchboxKey.toString(),  "%" +searchboxVal+"%");
			opMap.put(searchboxKey.toString(), Operator.lk);
		}

		//排序
		List<Object[]> orderList = new ArrayList();
		if (appData.getOrderField() != null){
			orderList.add(new Object[]{appData.getOrderField(), appData.getOrderType()});
		}
		
		Pagination pagination = new Pagination();
		int pageNo = 1;
		int pageSize = 10;
		if (appData.getPageNo() != null){
			pageNo = appData.getPageNo();
		}
		
		if (appData.getPageSize() != null){
			pageSize = appData.getPageSize();
		}
		pagination.setPageNo(pageNo);
		pagination.setPageSize(pageSize);
		
		
		pagination  = this.getLookupProvider().lookupPage(qryEntity, opMap, orderList, pagination);
		
		return pagination;
	}
	
	
	public Object addEntity(BasEntity entity){
		
		BasBIZ basBiz = (BasBIZ) this.getBean("basBIZImpl");
		return basBiz.addEntity(entity);
	}
	
	public BasEntity modifyEntity(BasEntity entity) {
		BasBIZ basBiz = (BasBIZ) this.getBean("basBIZImpl");
		return basBiz.modifyEntity(entity);
	}
	
	
	public BasEntity removeEntity(BasEntity entity) {
		
		BasBIZ basBiz = (BasBIZ) this.getBean("basBIZImpl");
		return basBiz.removeEntity(entity);
	}
	
	/**
	 * 采用mybatis的查询，可用于多表进行查询,一般用于GRID列表
	 * @param appData 前端传入的参数
	 * @param sql SQL语句，如：select t.id id, t.code code, t.name name, t.val val, t.remark remark, t.entity_sid entitySid from frm_bas_cfg t
	 * 
	 */
	public Pagination<Map<String, Object>> queryPageList(AppData appData, String sql) {
		
		BasBIZ basBiz = (BasBIZ) this.getBean("basBIZImpl");
		return basBiz.queryPageList(appData, sql);
		
	}


}
