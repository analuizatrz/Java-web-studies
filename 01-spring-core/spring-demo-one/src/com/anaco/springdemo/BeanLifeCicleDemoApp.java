package com.anaco.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCicleDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beansLifeCicle-applicationContext.xml");
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		System.out.println(theCoach.getDailyFortune());
		// close the context
		context.close();

	}

}
