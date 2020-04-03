package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	
	
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
}
