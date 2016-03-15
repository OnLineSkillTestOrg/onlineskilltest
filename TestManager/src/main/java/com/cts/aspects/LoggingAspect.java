package com.cts.aspects;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class LoggingAspect {
	
	@Around("businessService()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
		final Logger LOGGER = LoggerFactory.getLogger(joinPoint.getSignature().getName());
		LOGGER.info("Class Name : "+joinPoint.getTarget().getClass());
		LOGGER.info( "Method start : "+joinPoint.getSignature().getName());
		LOGGER.info( "Method arguments : "+Arrays.toString(joinPoint.getArgs()));
		Object retVal =joinPoint.proceed(); //continue on the intercepted method
		LOGGER.info("Method end!");
		return retVal;
	}
	
	@Pointcut("execution(* com.cts.rest.service.*.*(..))") 
	private void businessService() {}  
	
	
	@PostConstruct
	public void init(){
		System.out.println("This is a test :: hiya");
	}
	
}