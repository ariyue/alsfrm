package com.als.frm.comm;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.core.util.Loader;
import org.jdom.Document;

import com.als.frm.comm.util.FileUtil;
import com.als.frm.ex.AppException;

public class FrmConstant {

	/**
	 * 系统配置文件
	 */
	public static Document appCfgDocument;
	
	public static Map appInitParams;

	public static Locale DEFAULT_LOCALE = Locale.SIMPLIFIED_CHINESE;//Locale.ENGLISH;//
	
	public static Locale getLocale(String s) {

		Locale lc = DEFAULT_LOCALE;
		if (s.equals("01")) {
			lc = Locale.SIMPLIFIED_CHINESE;
		} else if (s.equals("02")) {
			lc = Locale.TRADITIONAL_CHINESE;
		} else if (s.equals("03")) {
			lc = Locale.ENGLISH;
		}
		return lc;
	}

	static {
		String fileName = "/config/als-app.xml";
		Document doc = FileUtil.readXmlFile(fileName);
		if (doc != null){
			appCfgDocument = doc;
		} else {
			throw new AppException("err.als.02001", new Object[]{fileName} );
		}
	}

	static {
		String fileName = "/config/als-init.properties";
		Map params = FileUtil.readPropertisFile(fileName);
		if (params == null){
			throw new AppException("err.als.02001", new Object[]{fileName} );
		} else {
			appInitParams = params;
		}
	}
	public static final String FRM_DEFAULT_ENTITY_SID = "00000";//框架默认的企业简码(开发人员采用此entitySid进入)
	
	public static final String SQL_IST_BAS_CONSTANT = "insert into frm_bas_constant(id, name, code, item_code, item_text, row_order, entity_sid, remark) values (:id, :name, :code, :itemCode, :itemText, :rowOrder, :entitySid, :remark)";
	public static final String SQL_UDT_BAS_CONSTANT = "update frm_bas_constant set id=:id,name=:name,code=:code,item_code=:itemCode,item_text=:itemText,row_order=:rowOrder,entity_sid=:entitySid,remark=:remark where id=:id";
	public static final String SQL_DLT_BAS_CONSTANT = "delete from frm_bas_constant where id=:id";
	public static final String SERIAL_KEY_CURRENT_VALUE = "_serial_current_value";
	public static final String SERIAL_KEY_MAX_VALUE = "_serial_max_value";
	public static final String SERIAL_KEY_PREFIX = "_serial_prefix";//前辍
	public static final String SERIAL_KEY_SUBFIX = "_serial_subfix";//后辍
	
	
	/**
	 * 登陆用户的session名
	 */
	public static String SESSION_NAME_4_LOGIN_USER = "token";
	
	/**
	 * 上传文件的进度session
	 */
	public static String SESSION_NAME_4_UPLOAD_PERCENT = "uploadPercent";
	
	public static String USER_TYPE_4_ADMIN = "4"; //用户类型-系统超级管理员
	public static String USER_TYPE_4_DEV = "3"; //用户类型-系统开发人员
	public static String USER_TYPE_4_ENTITY_USER = "1"; // 用户类型-企业用户
	public static String USER_TYPE_4_ENTITY_CUSTOMER = "2"; // 用户类型-企业客户
	public static String USER_TYPE_4_ENTITY_VISITOR = "0"; // 用户类型-游客
	public static String USER_TYPE_4_AGENT = "5"; // 用户类型-经营代理人

}
