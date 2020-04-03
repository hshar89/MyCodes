package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public void addAccount() {
		System.out.println(getClass()+" :Doing my DB Work: Add an account");
	}
    
	public void addAccount(Account account) {
		System.out.println(getClass()+" :Doing my DB Work: Add an account with account parameter");
	}
	public void addAccount(Account account,boolean sometest) {
		System.out.println(getClass()+" :Doing my DB Work: Add an account with account and boolean param");
	}
	public void addUpdateAccount() {
		System.out.println(getClass()+" :Doing my DB Work: Add/Update account");
	}
	
	public String getName() {
		System.out.println(getClass()+": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
  
	public List<Account> findAccounts(){
		
		List<Account> myaccs = new ArrayList<>();
		
		Account acc1 = new Account("John","Silver");
		Account acc2 = new Account("Madhu","Platinum");
		Account acc3 = new Account("Luka","Gold");
		myaccs.add(acc1);
		myaccs.add(acc2);
		myaccs.add(acc3);
		return myaccs;
	}

}
