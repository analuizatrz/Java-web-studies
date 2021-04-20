package com.anaco.springdemoannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// read sprint config file
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		var context = new AnnotationConfigApplicationContext(SportConfig.class);
		// get the bean from spring container
		var sillyCoach = context.getBean("thatSillyCoach", TennisCoach.class);
		
		// call a method on the bean
		System.out.println(sillyCoach.getDailyWorkout());
		
		// call the method to get daily fortune
		System.out.println(sillyCoach.getDailyFortune());
		
		context.close();
	}
}
