package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
		
	}
	public void addSillyMember() {
		
		System.out.println(getClass() + ": Silly Silly Silly member added");
		
	}
	public boolean addBoolean() {
		
		System.out.println(getClass() + ": boolean return");
		return true;
		
	}
	public void goToSleep() {
		
		System.out.println(getClass() + ": goToSleep()");
		
	}
}
