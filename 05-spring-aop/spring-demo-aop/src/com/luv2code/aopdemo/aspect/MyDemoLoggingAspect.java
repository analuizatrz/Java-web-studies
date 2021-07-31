package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	//@Before("execution(public void addAccount())") // every addAccount method of any Class
	//@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())") // addAccount of AccountDAO
	//@Before("execution(public void add*())") // every method starting with add of any Class and return void
	
	//@Before("execution(* add*())") // every method starting with add of any Class and any return
	//@Before("execution(boolean add*())") // every method starting with add of any Class and boolean return
	
	//@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))") // every method starting with add of any Class and any return, with first parameter Account
	
	//@Before("execution(* add*(..))") // match all parameters
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") //same as before but from a specific package
	
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
		
	}
}