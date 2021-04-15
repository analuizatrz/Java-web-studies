package com.anaco.springdemoannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		var oi = context.getBean("thatSillyCoach", TennisCoach.class);
		System.out.println(oi.getDailyWorkout());
		context.close();
	}

}
