package com.als.frm.comm.util;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.als.frm.comm.FrmConstant;
import com.als.frm.comm.dto.Token;
import com.als.frm.spr.SpringContextUtil;

/**
 * 国际化组件工具类
 * @author Vincent
 *
 */
@Component
public class MessageUtil {
	
	private static MessageSource getMessageSource(){
		return (MessageSource) SpringContextUtil.getBean("messageSource");
	}
	
	
	private static Locale getUserLocale(){
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session  = request.getSession();
		Locale l = FrmConstant.DEFAULT_LOCALE;
		Token token = (Token) session.getAttribute(FrmConstant.SESSION_NAME_4_LOGIN_USER);
		if (token != null){
			String ul= token.getUserLanguage();
			l = FrmConstant.getLocale(ul);
		}
		return l;
	}
	
	/**
	 * 国际化
	 * @param key 键，来自message***.xml
	 * @param params 参数
	 * @param appFlag 是否是应用程序表单国际化 true,如果是错误信息，为false
	 * @return
	 */
	public static String getMessage(String key, Object[] params, boolean appFlag){
		
		String keyMsg = "";
		if (!appFlag){
			if (key.indexOf("err") == 0){
				keyMsg = "【"+ key +"】";
			}
		}
		MessageSource messageSource = getMessageSource();
		return keyMsg + messageSource.getMessage(key, params, getUserLocale());
	}
}
