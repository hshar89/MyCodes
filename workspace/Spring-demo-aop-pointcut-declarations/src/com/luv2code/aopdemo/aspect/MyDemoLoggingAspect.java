package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {

	//this is an aspect - where we add all of our related advices
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution( * com.luv2code.aopdemo.dao.*.get*(..)")
	private void getter() {}

	@Pointcut("execution( * com.luv2code.aopdemo.dao.*.set*(..)")
	private void setter() {}
	
	@Pointcut("exectuion(forDaoPackage() && !(getter() || setter()))")
	private void forDaoPackageNoGetterSetter() {}
		
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\nExecuting @Before advice on addAccount");
	}
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("Perfoming API analytics");
		
	}
	
}
