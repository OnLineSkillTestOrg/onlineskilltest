package com.cts.aspects;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class ExceptionAspect {
	
	
	
	@AfterThrowing(pointcut = "businessService()", throwing = "e")
	  public void handleException(JoinPoint joinPoint, Throwable e) {
			final Logger LOGGER = LoggerFactory.getLogger(joinPoint.getSignature().getName());
			LOGGER.error("Class Name : "+joinPoint.getTarget().getClass());
			LOGGER.error("Method start : "+joinPoint.getSignature().getName());
			LOGGER.error("Method arguments : "+Arrays.toString(joinPoint.getArgs()));
			StringWriter sWriter = new StringWriter();
			PrintWriter pr = new PrintWriter(sWriter);
			e.printStackTrace(pr);
			LOGGER.error("Exception Stack Trace : "+sWriter.getBuffer().toString());
			
	}
		
	
	@Pointcut("execution(* com.cts.rest.service.*.*(..))") 
	private void businessService() {}  
}
