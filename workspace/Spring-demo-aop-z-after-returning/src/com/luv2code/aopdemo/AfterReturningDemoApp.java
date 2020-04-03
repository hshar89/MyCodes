package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		//Read the spring java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from the container
		AccountDAO account = context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> accList = account.findAccounts();
		
		System.out.println("\nMain Program After Returning...");
		
		System.out.println(accList);
		
		System.out.println("\n");
		context.close();	

	}

}
