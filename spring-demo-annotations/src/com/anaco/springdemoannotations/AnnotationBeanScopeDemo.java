package com.anaco.springdemoannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemo {

	public static void main(String[] args) {
		var context = new ClassPathXmlApplicationContext("applicationContext.xml");
		var coach = context.getBean("thatSillyCoach", Coach.class);
		var alphaCoach = context.getBean("thatSillyCoach", Coach.class);
		
		boolean result = coach == alphaCoach;
		
		System.out.println(result);
		System.out.println("Memory location for coach"+ coach);
		System.out.println("Memory location for alphacoach"+ alphaCoach);
		System.out.println(result);
	}
}
