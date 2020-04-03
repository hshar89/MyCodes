package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//Read the spring java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from the container
		AccountDAO account = context.getBean("accountDAO",AccountDAO.class);
		
		MembershipDAO member = context.getBean("membershipDAO",MembershipDAO.class);
		//call the business method
		Account acc = new Account("test","3");
		account.addAccount();
		account.addAccount(acc);
		account.addAccount(acc, true);
		
		account.setName("foobar");
		account.setServiceCode("silver");
		String name = account.getName();
		String code = account.getServiceCode();
		
		member.addAccount();
		account.addUpdateAccount();
		context.close();	

	}

}
