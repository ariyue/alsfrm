package com.als.abc.module.tst;


import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class I18nTester {
 
	public static void main(String[] args) { 
		   MessageSource messageSource = new ClassPathXmlApplicationContext("config/als-context.xml");  
		   String message11 = messageSource.getMessage("err.sys.10002", null, Locale.ENGLISH);
		   String message12 = messageSource.getMessage("err.sys.10002", null, Locale.CHINESE);
		   String message13 = messageSource.getMessage("err.sys.10002", null, Locale.TRADITIONAL_CHINESE);
		   System.out.println(message11);
		   System.out.println(message12);
		   System.out.println(message13);
		   
		   //含有一个参数的，第一个参数代表properties中的{0},第二个参数代表properties中的{1}，以此类推
		   String message21 = messageSource.getMessage("err.sys.10008", new Object[]{"UserAction","getUserList"}, Locale.ENGLISH);
		   String message22 = messageSource.getMessage("err.sys.10008", new Object[]{"UserAction","getUserList"}, Locale.CHINESE);
		   String message23 = messageSource.getMessage("err.sys.10008", new Object[]{"UserAction","getUserList"}, Locale.TRADITIONAL_CHINESE);
		   System.out.println(message21);
		   System.out.println(message22);
		   System.out.println(message23);
	}

}

