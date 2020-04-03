package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLogginAspect {

	//setup logger
	private Logger logger = Logger.getLogger(CRMLogginAspect.class.getName());
	//setup pointcut declaration
	
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	//add @before Annotation
	
	@Before("forAppFlow()")
	public void before(JoinPoint jp) {
		
		//display method we are calling
		String method = jp.getSignature().toShortString();
		
		logger.info("@Before calling method: "+method);
		
		Object[] args = jp.getArgs();
		for(Object temp: args) {
			logger.info("argument###"+temp);
		}
	}
	//add @afterreturning advice
	@AfterReturning(pointcut="forAppFlow()",returning="result")
	public void afterReturning(JoinPoint jp, Object result) {
		logger.info("in @AfterReturning from Method: "+jp.getSignature().toShortString());
		
		logger.info("======> result: "+result);
	}
	
	
}
