package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	public void addAccount() {
		System.out.println(getClass()+" doing my db work");
	}
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": receive account");
		
	}
	public void doWork() {
		
		System.out.println(getClass() + ": doWork()");
		
	}
}
