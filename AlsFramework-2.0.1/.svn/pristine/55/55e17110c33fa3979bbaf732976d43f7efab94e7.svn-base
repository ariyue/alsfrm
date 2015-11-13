package com.als.web.action;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;

/**
 * Action类加载器
 * 
 * @author Vincent
 * 
 */
public class ActionLoader {

	public static Map<String, String> ACTION_MAP = new HashMap();

	/**
	 * 一次性加载所有的action类
	 */
	public void loadActions() {

		// TODO 配置在xml中
		                         
		String scanPackageName = "com.als";//"com.als.web.action.demo";
		ClassScanner scanner = new ClassScanner();
		// 读取配置文件取得所有的class对象
		Set<Class<?>> classs = scanner.getClasses(scanPackageName);

		// 遍历class对象
		for (Class<?> cc : classs) {
			// 如果class对象上面有@action的注释
			if (cc.isAnnotationPresent(Action.class)) {
				// 取得注释对象 用来获取@action注释的内容
				Action action = cc.getAnnotation(Action.class);
				// allActionMap.put(cc.getName(), action.value());
				// 根据class对象取得他的方法对象
				//Method[] methods = cc.getDeclaredMethods();
				// 用以下的方式可以向父类一起查找
				Method[] methods = cc.getMethods();
				// 遍历方法对象
				for (Method method : methods) {
					// 判断方法对象上面有没有@ActionMetod注释
					if (method.isAnnotationPresent(ActionMetod.class)) {
						// 取得注释对象，用来获取@ActionMetod注释内容
						ActionMetod actionMetod = method
								.getAnnotation(ActionMetod.class);
						// 拼接成map集合 是 url对应类的方法 如 loginAction/login 对应
						// com.yht.loginAction.login
						ACTION_MAP.put(action.value() + "/"
								+ actionMetod.value(), cc.getName() + "."
								+ method.getName());
					}
				}
			}
		}
	}
}
