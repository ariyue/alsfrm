package com.als.abc.module.tst;

import java.lang.management.ManagementFactory;
import java.util.List;

public class DebugTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> args3 = ManagementFactory.getRuntimeMXBean().getInputArguments();
		boolean isDebug = false;
		for (String arg : args3) {
		  if (arg.startsWith("-Xrunjdwp") || arg.startsWith("-agentlib:jdwp")) {
		    isDebug = true;
		    break;
		  }
		}
		if (isDebug){
		    System.out.println("debuging............");
		    System.exit(0);
		}else {
		    System.out.println("running............");
		}

	}

}
