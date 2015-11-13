package com.als.frm.bas.ddl;

import java.util.Locale;


/**
 * 语言国际化
 * @author Vincent
 *
 */
public enum  LanguageEnum implements ILanguageEnum {

	//数据库定义在ums_user表中
	ZH_CN("01"),ZH_TW("02"),EN("0");
	
	private Locale locale = Locale.CHINESE;
	
	//构造函数必须为private的,防止意外调用  
    private LanguageEnum(String s){  

    	if(s.equals("01")){
    		this.locale = Locale.CHINESE;
    	} else if (s.equals("02")){
    		this.locale = Locale.TAIWAN;
    	}else if (s.equals("03")){
    		this.locale = Locale.ENGLISH;
    	}
    } 
	
    @Override
    public Locale getLocale(){
    	
    	return this.locale;
    }
    
    public static void main(String[] args) {
		System.out.println(LanguageEnum.ZH_TW.getLocale());
	}
}
