package com.als.web.action;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ContextListener
 * @author Vincent
 *
 */
public class ContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent e) {
		
	}

	public void contextInitialized(ServletContextEvent e) {
		
		System.out.println("------------开始加载als web action---------------------------------");
		ActionLoader loader = new ActionLoader();
		loader.loadActions();
		System.out.println("------------结束加载als web action---------------------------------");
	}
}


