package com.als.frm.bas.web;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.als.frm.bas.ddl.RstMsgType;
import com.als.frm.bas.ddl.RstType;
import com.als.frm.comm.dto.RstData;
import com.als.frm.comm.dto.RstMsg;
import com.als.frm.ex.AppException;

@Aspect
public class ControllerHandler {

	private static Logger logger = Logger.getLogger(ControllerHandler.class);
	
	@Around("execution(* com.als..module..act..*.*(..))")
	public RstData doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		
		String cn = pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName();
		logger.info(cn + "wrap start ------------------------------------------------------------");
		
		RstData ajaxResultVO = new RstData();
		Object obj = new Object();
		try {
			obj = pjp.proceed();
			ajaxResultVO.setResult(obj);
		} catch (Exception e) {

			throw new AppException("err.sys.10004", new Object[]{});
		}
		
		logger.info(cn + "wrap end ------------------------------------------------------------");
		return ajaxResultVO;
	}

}
