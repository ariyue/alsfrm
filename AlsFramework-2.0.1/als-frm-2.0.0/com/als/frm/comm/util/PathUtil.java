package com.als.frm.comm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

public  class PathUtil {

	public static final String PATH_SEPARATOR = System.getProperty("file.separator");
	/**
	 * 返回项目web访问根目录
	 * @param request 
	 * @return 如 http://localhost:8080/HelloDorado/
	 */
	public static String getRootWebPath(HttpServletRequest request){
		
		return  request.getScheme() + ":" + PATH_SEPARATOR + PATH_SEPARATOR +  request.getServerName()  +  ":"  +  request.getServerPort()  +  request.getContextPath();
	}
	
	/**
	 * 返回保存在硬盘时的项目根目录
	 * @param request
	 * @return
	 */
	public static String getRootDiskPath(HttpServletRequest request){
		
		return request.getRealPath("/");
	}
	
	private static final String UPLOAD_FLODER = "uploadfiles";
	/**
	 * 返回上传文件所保存的目录
	 * @param request
	 * @return
	 */
	public static String getFileUploadFloder(HttpServletRequest request){
		
		return getRootDiskPath(request) + PATH_SEPARATOR + UPLOAD_FLODER;
	}
	
	public static String getFileReadFloder(HttpServletRequest request){
		
		return UPLOAD_FLODER;
	}
	
	
}
