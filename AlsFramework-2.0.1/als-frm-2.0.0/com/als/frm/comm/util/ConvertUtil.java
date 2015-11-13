package com.als.frm.comm.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.als.frm.ex.AppException;

/**
 * 转化工具
 * 
 * @author Vincent
 * 
 */
public class ConvertUtil {

	public static void main(String[] args) {

		/*System.out.println(ConvertUtil.convert2ColumnName("recProvinceCode"));
		System.out.println(ConvertUtil
				.convert2PropertyName("rec_province_code"));*/
		
		System.out.println(ConvertUtil.convert2DbDate("2012-05-20"));
	}

	/**
	 * 将数据库列名转化为实体属性名
	 * 
	 * @param columnName
	 *            　数据库列名，如:user_name
	 * @return 实体属性名 ，如：userName
	 */
	public static String convert2PropertyName(String columnName) {

		StringBuffer sb = new StringBuffer();
		char c = "_".charAt(0);
		for (int i = 0, len = columnName.length(); i < len; i++) {
			char ch = columnName.charAt(i);
			if (c == ch && (i + 1) < len) {
				sb.append(Character.toUpperCase(columnName.charAt(i + 1)));
				i++;
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	/**
	 * 将实体属性名转化为列名
	 * 
	 * @param propertyName
	 *            实体属性名，如：userName
	 * @return 列名,如:user_name
	 */
	public static String convert2ColumnName(String propertyName) {

		StringBuffer sb = new StringBuffer();
		for (int i = 0, len = propertyName.length(); i < len; i++) {
			char ch = propertyName.charAt(i);
			if (Character.isUpperCase(ch)) {
				sb.append("_" + Character.toLowerCase(ch));
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	/**
	 * 将bean转为map
	 * @param bean
	 * @return
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Map convert2Map(Object bean) {
		
		try {
			Class type = bean.getClass();
			Map returnMap = new HashMap();
			BeanInfo beanInfo = Introspector.getBeanInfo(type);

			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!propertyName.equals("class")) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(bean, new Object[0]);
					if (result != null) {
						returnMap.put(propertyName, result);
					} else {
						returnMap.put(propertyName, "");
					}
				}
			}
			return returnMap;
		} catch (Exception e) {
			throw new AppException("将POJO转为Map出错!");
		}
	}

	/**
	 * 将map转为bean
	 * @param clazz
	 * @param map
	 * @return
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 */
	public static Object convert2Bean(Class clazz, Map map){
		
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz); // 获取类属性
			Object obj = clazz.newInstance(); // 创建 JavaBean 对象

			// 给 JavaBean 对象的属性赋值
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();

				if (map.containsKey(propertyName)) {
					// 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
					Object value = map.get(propertyName);
					Object[] args = new Object[1];
					args[0] = value;
					descriptor.getWriteMethod().invoke(obj, args);
				}
			}
			return obj;
		} catch (Exception e) {
			throw new AppException("将Map转为POJO出错!");
		}
	}
	
	/**
	 * 将mapList转为beanList
	 * @param clazz
	 * @param mapList
	 * @return
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 */
	public static List convert2BeanList(Class clazz, List<Map> mapList) {
		List beanList = new ArrayList();
		for (int i = 0, len = mapList.size(); i < len; i++){
			beanList.add(convert2Bean(clazz, mapList.get(i)));
		}
		return beanList;
	}
	
	/**
	 * 将数据库的日期转为页面视图的日期
	 * @param dbDate 如20130228
	 * @return
	 */
	public static String convert2ViewDate(String dbDate){
		
		//对于不符合转化的日期直接输出
		if (dbDate == null || dbDate.length() != 8){
			return dbDate;
		}
		String y = dbDate.substring(0, 4);
		String m = dbDate.substring(4, 6);
		String d = dbDate.substring(6, 8);
		return y + "-" + m + "-" + d;
	}
	
	/**
	 * 将视图的日期转为页面数据库的日期
	 * @param viewDate
	 * @return
	 */
	public static String convert2DbDate(String viewDate){
		
		return viewDate.replaceAll("-", "");
	}
	
	/**
	 * 将数据库的时间转为页面视图的时间
	 * @param dbTime 如161040
	 * @return
	 */
	public static String convert2ViewTime(String dbTime){
		
		//对于不符合转化的时间直接输出
		if (dbTime != null){
			int len =  dbTime.length();
			String h = "";
			String m = "";
			String s = "";
			if (len == 4){
				h = dbTime.substring(0, 2);
				m = dbTime.substring(2, 4);
				return h + ":" + m;
			} else if (len == 6){
				h = dbTime.substring(0, 2);
				m = dbTime.substring(2, 4);
				s = dbTime.substring(4, 6);
				return h + ":" + m + ":" + s;
			} else {
				return dbTime;
			}
		} else {
			return "";
		}
	}
	
	/**
	 * 将视图的时间转为页面数据库的时间
	 * @param viewDate
	 * @return
	 */
	public static String convert2DbTime(String viewTime){
		
		return viewTime.replaceAll(":", "");
	}
	
	/**
	 * 将bean列表转为Map对象
	 * @param beanList
	 * @param keyPropertyName 键名
	 * @param valuePropertName 值名
	 * @return
	 */
	public static Map covert2Map(List beanList,String keyPropertyName, String valuePropertName){
		
		int len = beanList.size();
		Map<Object ,Object> map = new HashMap<Object, Object>(len);
		try {
			for (int i = 0; i < len; i ++){
				Object record = beanList.get(i);
				map.put(BeanUtil.getFieldValue(record, keyPropertyName), BeanUtil.getFieldValue(record, valuePropertName));
			}
		} catch (Exception e) {
			
			throw new  AppException("将BEAN转为Map出错！" + e);
		}
		return map;
	}
	
	
}
