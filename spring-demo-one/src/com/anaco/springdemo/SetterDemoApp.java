package com.anaco.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
	public static void main(String[] args) {
		var context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TrackCoach theCoach = context.getBean("myTrackCoach", TrackCoach.class);
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getEmailAdress());
		System.out.println(theCoach.getTeams());
		context.close();		
	}
}
