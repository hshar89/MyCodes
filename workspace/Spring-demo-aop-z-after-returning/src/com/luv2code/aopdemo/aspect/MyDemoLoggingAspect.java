package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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

	//this is an aspect - where we add all of our related advices
	@Before("com.luv2code.aopdemo.aspect.LuvAOPExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint jp) {
		System.out.println("\nExecuting @Before advice on addAccount");
		
		//display the method signature
		MethodSignature ms = (MethodSignature)jp.getSignature();
		System.out.println("Method signature: "+ms);
		//display method arguments
		for(Object o: jp.getArgs()) {
			System.out.println("Argument value: "+ o);
		}
	}
	
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",returning="result")
	public void afterReturningFindAccounts(JoinPoint jp, List<Account> result) {
		
		String method = jp.getSignature().toShortString();
		System.out.println("Executing After Returning on method: "+method);
		
		System.out.println("result is:: "+result);
		
		convertAccountNamesToUpperCase(result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for(Account acc: result) {
			acc.setName(acc.getName().toUpperCase());
		}
	}
	
}
