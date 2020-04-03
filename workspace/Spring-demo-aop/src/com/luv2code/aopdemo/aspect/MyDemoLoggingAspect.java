package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {

	//this is an aspect - where we add all of our related advices
	
	//@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	//@Before("execution(void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	@Before("execution(void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("Executing @Before advice on addAccount");
	}
	@Before("execution( * add*(..))")
	public void beforeAddAccountAdvice2() {
		System.out.println("Executing @Before advice2 on addAccount");
	}
	@Before("execution( * addAccount(com.luv2code.aopdemo.Account,..))")
	public void beforeAddAccountAdvice3() {
		System.out.println("Executing @Before advice3 on addAccount");
	}
	@Before("execution( * com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice4() {
		System.out.println("Executing @Before advice4 on addAccount");
	}
}
