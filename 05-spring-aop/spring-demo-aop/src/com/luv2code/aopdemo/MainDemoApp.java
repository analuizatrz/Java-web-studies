package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO daccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		daccountDAO.addAccount();

		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		membershipDAO.addAccount();
		membershipDAO.addSillyMember();
		
		System.out.println("\nlet's call it again!\n");
		
		daccountDAO.addAccount();
				
		context.close();
	}
}