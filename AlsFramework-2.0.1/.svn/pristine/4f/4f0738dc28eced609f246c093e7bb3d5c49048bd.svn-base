package com.als.frm.comm.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.beanutils.BeanMap;
import org.springframework.util.Assert;

import com.als.frm.ex.AppException;

/**
 * 对Bean进行操作的相关工具方法
 *
 */
public class BeanUtil {
	
	/** 
     * 获取当前类声明的private/protected变量 
     */  
    static public Object getFieldValue(Object object, String propertyName) {  
        try {
			Assert.notNull(object);  
			Assert.hasText(propertyName);  
			Field field = object.getClass().getDeclaredField(propertyName);  
			field.setAccessible(true);  
  
			return field.get(object);
		} catch (Exception e) {
			//throw new Exception("获取属性类型出错!");
			return null;
		} 
    }  
    /** 
     * zhangpf :因为getFieldValue()办法,无法读取super class的属性的值； 
     *                  所以本办法做出扩大,容许读取super class的属性的值； 
     * ＠param object 
     * ＠param propertyName 
     * ＠return 
     * ＠throws IllegalAccessException 
     * ＠throws NoSuchFieldException 
     */  
    public static Object getFieldValueInAllSuper(Object object, String propertyName)  
            throws IllegalAccessException, NoSuchFieldException {  
        Assert.notNull(object);  
        Assert.hasText(propertyName);  
        Class claszz=object.getClass();  
        Field field = null;  
          
        do  
        {     
            try{  
                field = claszz.getDeclaredField(propertyName);  
            }  
            catch(NoSuchFieldException e)  
            {  
                //e.printStackTrace();  
                field=null;  
            }  
            claszz=claszz.getSuperclass();  
        }  
        while(field==null&&claszz!=null);  
          
        if(field==null) return null;  
   
        field.setAccessible(true);  
        return field.get(object);  
    }  
	
    
	/**
	 * 将Bean对象转换成Map对象，将忽略掉值为null或size=0的属性
	 * @param obj 对象
	 * @return 若给定对象为null则返回size=0的map对象
	 */
	public static Map<String, Object> toMap(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj == null) {
			return map;
		}
		BeanMap beanMap = new BeanMap(obj);
		Iterator<String> it = beanMap.keyIterator();
		while (it.hasNext()) {
			String name = it.next();
			Object value = beanMap.get(name);
			// 转换时会将类名也转换成属性，此处去掉
			if (value != null && !name.equals("class")) {
				map.put(name, value);
			}
		}
		return map;
	}

	/**
	 * 该方法将给定的所有对象参数列表转换合并生成一个Map，对于同名属性，依次由后面替换前面的对象属性
	 * @param objs 对象列表
	 * @return 对于值为null的对象将忽略掉
	 */
	public static Map<String, Object> toMap(Object... objs) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (Object object : objs) {
			if (object != null) {
				map.putAll(toMap(object));
			}
		}
		return map;
	}

	/**
	 * 获取接口的泛型类型，如果不存在则返回null
	 * @param clazz
	 * @return
	 */
	public static Class<?> getGenericClass(Class<?> clazz) {
		Type t = clazz.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			return ((Class<?>) p[0]);
		}
		return null;
	}
	
	/**
     * 属性文件向Bean赋值
     * @param bean
     * @param prop
     */
    public static void propertyToBean(Object bean,Properties prop){
        if(prop == null)return;
        Iterator<Object> keyIt = prop.keySet().iterator();
        Class beanClass = bean.getClass();
        while(keyIt.hasNext()){
            try{
                String key = (String)keyIt.next();
                String value = prop.getProperty(key);
                 
                Field field = beanClass.getDeclaredField(key);
                Class fieldClass = field.getType();
                Method method = beanClass.getDeclaredMethod("set"+StringUtil.toUpperCaseFirstOne(key), fieldClass);
                 
                String simpleName = fieldClass.getSimpleName();
                if(simpleName.equals("boolean")){
                    method.invoke(bean, Boolean.parseBoolean((String)value));
                }else if(simpleName.equals("String")){
                    method.invoke(bean, value);
                }else{
                    BigDecimal bd = new BigDecimal(value);
                    Method convertMethod = bd.getClass().getDeclaredMethod(simpleName+"Value");
                    method.invoke(bean, convertMethod.invoke(bd));
                }
            }catch(NoSuchFieldException ex){
                continue;
            }catch(Exception ex){
                //log.error(ex.getMessage(),ex);
            }
        }
    }
    
    /**
	 * 将Bean对象转换成数据库Map对象,
	 * @param obj 对象
	 * @return 若给定对象为null则返回size=0的map对象
	 */
	public static Map<String, Object> toColumnMap(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj == null) {
			return map;
		}
		BeanMap beanMap = new BeanMap(obj);
		Iterator<String> it = beanMap.keyIterator();
		while (it.hasNext()) {
			String name = it.next();
			Object value = beanMap.get(name);
			// 转换时会将类名也转换成属性，此处去掉
			if (value != null && !name.equals("class")) {
				map.put(toUnderlineString(name), value);
			}
		}
		return map;
	}
	/**
	 * 将map转为bean
	 * @param map 要转化的对象
	 * @param obj 转化的bean
	 * @param hasUnderline　是否是含有下划线的map，如数据库字段生成的map的key时含有下划线
	 */
    public static void toBean(Map<String, Object> map, Object obj, boolean hasUnderline) {  
  
    	String key="";
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
           
            for (PropertyDescriptor property : propertyDescriptors) {  
                key = property.getName();
                if (hasUnderline){
                	key =  toUnderlineString(key); 
                }
                
                if (map.containsKey(key)) {  
                    Object value = map.get(key);  
                    // 得到property对应的setter方法  
                    Method setter = property.getWriteMethod();  
                    setter.invoke(obj, value);  
                }  
  
            }  
  
        } catch (Exception e) {  
            System.out.println("transMap2Bean Error " + e);  
            throw new AppException("err.als.03002", new Object[]{key});
        }  
  
        return;  
  
    }  
    
    private static final char SEPARATOR = '_';  
    
    /** 
     * 将属性样式字符串转成驼峰样式字符串<br> 
     * (例:branchNo -> branch_no)<br> 
     *  
     * @param inputString 
     * @return 
     */  
    public static String toUnderlineString(String inputString) {  
        if (inputString == null)  
            return null;  
        StringBuilder sb = new StringBuilder();  
        boolean upperCase = false;  
        for (int i = 0; i < inputString.length(); i++) {  
            char c = inputString.charAt(i);  
  
            boolean nextUpperCase = true;  
  
            if (i < (inputString.length() - 1)) {  
                nextUpperCase = Character.isUpperCase(inputString.charAt(i + 1));  
            }  
  
            if ((i >= 0) && Character.isUpperCase(c)) {  
                if (!upperCase || !nextUpperCase) {  
                    if (i > 0)  
                        sb.append(SEPARATOR);  
                }  
                upperCase = true;  
            } else {  
                upperCase = false;  
            }  
  
            sb.append(Character.toLowerCase(c));  
        }  
  
        return sb.toString();  
    }  
    
    /** 
     * 将驼峰字段转成属性字符串<br> 
     * (例:branch_no -> branchNo )<br> 
     *  
     * @param inputString 
     *            输入字符串 
     * @param firstCharacterUppercase 
     *            是否首字母大写 
     * @return 
     */  
    public static String toCamelCaseString(String inputString, boolean firstCharacterUppercase) {  
        if (inputString == null)  
            return null;  
        StringBuilder sb = new StringBuilder();  
        boolean nextUpperCase = false;  
        for (int i = 0; i < inputString.length(); i++) {  
            char c = inputString.charAt(i);  
  
            switch (c) {  
            case '_':  
            case '-':  
            case '@':  
            case '$':  
            case '#':  
            case ' ':  
            case '/':  
            case '&':  
                if (sb.length() > 0) {  
                    nextUpperCase = true;  
                }  
                break;  
  
            default:  
                if (nextUpperCase) {  
                    sb.append(Character.toUpperCase(c));  
                    nextUpperCase = false;  
                } else {  
                    sb.append(Character.toLowerCase(c));  
                }  
                break;  
            }  
        }  
  
        if (firstCharacterUppercase) {  
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));  
        }  
  
        return sb.toString();  
    }  
    
    

}