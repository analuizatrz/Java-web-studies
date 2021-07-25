package com.anaco.springdemoannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// read sprint config file
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		var context = new AnnotationConfigApplicationContext(SportConfig.class);
		// get the bean from spring container
		var sillyCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// call a method on the bean
		System.out.println(sillyCoach.getDailyWorkout());
		
		// call the method to get daily fortune
		System.out.println(sillyCoach.getDailyFortune());
		
		// call a method on the bean
		System.out.println(sillyCoach.getEmail());
		
		// call the method to get daily fortune
		System.out.println(sillyCoach.getTeam());
		
		context.close();
	}
}
