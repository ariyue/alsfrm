package com.als.abc.module.tst;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

/**
 * 
 * http://www.cnblogs.com/backpacker/archive/2012/12/10/2812100.html
 * 
 * 注意到，输出的log都是在ERROR
 * level上的，log4j定义了8个级别的log（除去OFF和ALL，可以说分为6个级别），优先级从高到低依次为：OFF
 * 、FATAL、ERROR、WARN、INFO、DEBUG、TRACE、 ALL。如果将log
 * level设置在某一个级别上，那么比此级别优先级高的log都能打印出来。例如，如果设置优先级为WARN，那么OFF、FATAL、ERROR、WARN
 * 4个级别的log能正常输出，而INFO、DEBUG、TRACE、
 * ALL级别的log则会被忽略。从我们实验的结果可以看出，log4j默认的优先级为ERROR或者WARN（实际上是ERROR）。
 * 
 * @author Vincent
 * 
 */
public class HelloLog4j {

	private static Logger logger;

	public static void main(String[] args) throws Exception {

		ConfigurationSource source;
		String path = "/config/log4j2.xml";
		URL url = HelloLog4j.class.getResource(path);
		source = new ConfigurationSource(new FileInputStream(new File(url
				.getPath())), url);
		Configurator.initialize(null, source);
		 logger = LogManager.getLogger("HelloLog4j222");
		 
		MyApplication myApplication = new MyApplication();

		logger.entry();
		logger.info("Hello, World!");
		myApplication.doIt();
		logger.error("Hello, World 222222!");
		logger.exit();
	}
}