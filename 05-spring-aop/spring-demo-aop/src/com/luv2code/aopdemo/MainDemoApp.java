package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO daccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		daccountDAO.addAccount();

		System.out.println("\nlet's call it again!\n");
		
		daccountDAO.addAccount();
				
		context.close();
	}
}