package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
@Aspect
@Order(1)
public class MyDemoLoggingAspect {
     private Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	//this is an aspect - where we add all of our related advices
	@Before("com.luv2code.aopdemo.aspect.LuvAOPExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint jp) {
		myLogger.info("\nExecuting @Before advice on addAccount");
		
		//display the method signature
		MethodSignature ms = (MethodSignature)jp.getSignature();
		myLogger.info("Method signature: "+ms);
		//display method arguments
		for(Object o: jp.getArgs()) {
			myLogger.info("Argument value: "+ o);
		}
	}
	
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",returning="result")
	public void afterReturningFindAccounts(JoinPoint jp, List<Account> result) {
		
		String method = jp.getSignature().toShortString();
		myLogger.info("Executing After Returning on method: "+method);
		
		myLogger.info("result is:: "+result);
		
		convertAccountNamesToUpperCase(result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for(Account acc: result) {
			acc.setName(acc.getName().toUpperCase());
		}
	}
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",throwing="theExc")
	public void afterThrowingFromFindAccount(JoinPoint jp, Throwable theExc) {
		myLogger.info("Calling from method: "+jp.getSignature().toShortString());
		myLogger.info("Exception For logging: "+theExc.getMessage());
	}
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterAdvice(JoinPoint jp) {
		myLogger.info(jp.getSignature().toShortString());
	}
	@Around("execution(* com.luv2code.aopdemo.service.TrafficFortuneService.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint pjp) throws Throwable{
		
		myLogger.info("Method in @around Advice: "+pjp.getSignature().toShortString());
		
		long start = System.currentTimeMillis();
		
		Object result = null;
		try {
	    result = pjp.proceed();
		}catch(Exception e) {
			myLogger.warning(e.getMessage());
			//result = "Major Accident! Don't Worry. Helicopter on the way.";
			throw e;
		}
		myLogger.info("Time taken to execute: "+(System.currentTimeMillis()-start));
		return result;
	}
	
}
