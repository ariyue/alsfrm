/**
 * 日志辅助类
 */
package com.als.frm.comm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import com.als.abc.module.tst.HelloLog4j;


public class LogHelper
{
	private static Logger logger = null;

    private static void init()
    {
    	
    	try {
			ConfigurationSource source;
			String path = "/config/log4j2.xml";
			URL url = HelloLog4j.class.getResource(path);
			source = new ConfigurationSource(new FileInputStream(new File(url
					.getPath())), url);
			Configurator.initialize(null, source);
			logger = LogManager.getLogger("AlsLog");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
    }

    public static Logger getLogger() 
    {
        if (null == logger) 
        {
            init();
        }
        return logger;
    }
    
    
    /**
     * 写入日志
     * @param ex
     */
    public static void error(String msg, Exception ex) {
        
    	msg += "\n" +  StackTraceUtil.getStackTrace(ex);
        getLogger().error(msg);
    }
    
    /**
     * 写入日志
     * @param ex
     */
    public static void writeInLog(Exception ex) {
        StringBuffer sb=new StringBuffer();
        if(ex.getMessage()!=null){
            sb.append(ex.getMessage());
        }
        sb.append(getDetail(ex));
        sb.append(StackTraceUtil.getStackTrace(ex));
        getLogger().error(sb.toString());
    }
    
    private static String getDetail(Exception e){
        
        StackTraceElement[] es=e.getStackTrace();
        
        if(es.length==0) return "";
        StringBuffer sb=new StringBuffer();
        sb.append(" 文件名: "+es[0].getFileName());
        sb.append(" 类名: "+es[0].getClassName());
        sb.append(" 方法: "+es[0].getMethodName());
        sb.append(" 行列: "+es[0].getLineNumber());
        return sb.toString();
    }
}
 