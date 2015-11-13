package com.als.abc.module.tst;

import org.apache.logging.log4j.LogManager;  
import org.apache.logging.log4j.Logger;  
  
  
public class MyApplication {  
    static Logger logger = LogManager.getLogger(MyApplication.class.getName());    
      
    public boolean doIt() { 
    	//输出的log都是在ERROR level上的，log4j定义了8个级别的log（除去OFF和ALL，可以说分为6个级别），优先级从高到低依次为：OFF、FATAL、ERROR、WARN、INFO、DEBUG、TRACE、 ALL。
    	//log默认输出级别为eror，所以info的没有输出
      logger.entry();   //Log entry to a method    
      logger.error("Did it again!");   //Log a message object with the ERROR level    
      logger.exit();    //Log exit from a method     
      return false;    
    }    
}  