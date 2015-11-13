package com.als.frm.comm.util;

public class StringUtil {

	/**
	 * 字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if (str == null || str.trim().equals("")){
			return true;
		}
		return false;
	}
	
	/**
	 * 字符串首字母小写
	 * @param str
	 * @return
	 */
	public static String toLowerCaseFirstOne(String str) {
		if (str == null || "".equals(str))
			return str;
		if (Character.isLowerCase(str.charAt(0)))
			return str;
		else
			return (new StringBuilder()).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1))
					.toString();
	}

	/**
	 * 字符串首字母大写
	 * @param str
	 * @return
	 */
	public static String toUpperCaseFirstOne(String str) {
		if (str == null || "".equals(str))
			return str;
		if (Character.isUpperCase(str.charAt(0)))
			return str;
		else
			return (new StringBuilder()).append(Character.toUpperCase(str.charAt(0))).append(str.substring(1))
					.toString();
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
